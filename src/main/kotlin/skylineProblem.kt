//       date: 2022-09-30
//      title: The Skyline Problem
//        url: https://leetcode.com/problems/the-skyline-problem/
// difficulty: hard
//------------------------------------------------------------------------------

fun getSkyline(buildings: Array<IntArray>): List<IntArray> =
    mapToList(Point::toIntArray, divideAndConquer(buildings.map(::intArrayToBuilding).toTypedArray()))

//------------------------------------------------------------------------------
// A couple of classes to make data more readable

private class Building(val leftX: Int, val rightX: Int, val height: Int)

private fun intArrayToBuilding(arr: IntArray): Building =
    Building(arr[0], arr[1], arr[2])

private class Point(val x: Int, val y: Int) {
    fun toIntArray(): IntArray = intArrayOf(x, y)
    operator fun component1(): Int = x
    operator fun component2(): Int = y
}

//------------------------------------------------------------------------------
// Let's reimplement Lisp lists :-)
// The code with Kotlin's List<T> runs out of time for me.

private class Cons<T>(val car: T, val cdr: Cons<T>? = null) {
    operator fun component1(): T = car
    operator fun component2(): Cons<T>? = cdr
}

private fun <T, R> map(f: (T) -> R, list: Cons<T>?): Cons<R>? =
    if (list == null) null else Cons(f(list.car), map(f, list.cdr))

private fun <T, R> mapToSequence(f: (T) -> R, list: Cons<T>?): Sequence<R> =
    sequence {
        if (list != null) {
            yield(f(list.car))
            yieldAll(mapToSequence(f, list.cdr))
        }
    }

private fun <T, R> mapToList(f: (T) -> R, list: Cons<T>?): List<R> =
    mapToSequence(f, list).toList()

//------------------------------------------------------------------------------

// Divide-and-conquer strategy which recursively splits buildings in half,
// constructs skyline for each part and merges them.
// Works with arrays for performance reasons.
private fun divideAndConquer(
    buildings: Array<Building>,
    start: Int = 0,
    end: Int = buildings.lastIndex
): Cons<Point>? =
    if (start > end) {
        null
    } else if (start == end) {
        val firstPair = Point(buildings[start].leftX, buildings[start].height)
        val secondPair = Point(buildings[start].rightX, 0)
        Cons(firstPair, Cons(secondPair, null))
    } else {
        val mid = (start + end) / 2
        val left = divideAndConquer(buildings, start, mid)
        val right = divideAndConquer(buildings, mid + 1, end)
        pruneSkyline(mergeSkylines(left, right))
    }

// Removes consecutive points from a list with the same y-coordinate.
// It is easier to first construct a skyline with redundant points,
// and then apply pruneSkyline.
private fun pruneSkyline(list: Cons<Point>?): Cons<Point>? =
    if (list == null) null else Cons(list.car, pruneSkylineRec(list.cdr, list.car.y))

private fun pruneSkylineRec(list: Cons<Point>?, previousY: Int): Cons<Point>? =
    when {
        list == null -> null
        list.car.y == previousY -> pruneSkylineRec(list.cdr, previousY)
        else -> Cons(list.car, pruneSkylineRec(list.cdr, list.car.y))
    }

// Merges two skylines constructed for different buildings.
private fun mergeSkylines(
    firstList: Cons<Point>?,
    secondList: Cons<Point>?,
    firstH: Int = 0,
    secondH: Int = 0
): Cons<Point>? =
    when {
        firstList == null && secondList == null ->
            null

        firstList == null ->
            map({ point: Point -> Point(point.x, Math.max(firstH, point.y)) }, secondList)

        secondList == null ->
            map({ point: Point -> Point(point.x, Math.max(secondH, point.y)) }, firstList)

        else -> {
            val (firstHead, firstTail) = firstList
            val (firstX, firstY) = firstHead
            val (secondHead, secondTail) = secondList
            val (secondX, secondY) = secondHead

            val newFirstList: Cons<Point>?
            val newFirstH: Int
            val newSecondList: Cons<Point>?
            val newSecondH: Int

            when {
                firstX > secondX -> {
                    newFirstList = firstList
                    newFirstH = firstH
                    newSecondList = secondTail
                    newSecondH = secondY
                }

                firstX < secondX -> {
                    newFirstList = firstTail
                    newFirstH = firstY
                    newSecondList = secondList
                    newSecondH = secondH
                }

                else -> {
                    newFirstList = firstTail
                    newFirstH = firstY
                    newSecondList = secondTail
                    newSecondH = secondY
                }
            }

            val skylineX = Math.min(firstX, secondX)
            val skylineY = Math.max(newFirstH, newSecondH)

            Cons(Point(skylineX, skylineY), mergeSkylines(newFirstList, newSecondList, newFirstH, newSecondH))
        }
    }
