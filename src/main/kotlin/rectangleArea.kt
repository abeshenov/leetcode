//       date: 2022-11-17
//      title: Rectangle Area
//        url: https://leetcode.com/problems/rectangle-area/
// difficulty: medium
//------------------------------------------------------------------------------

// Here are the two rectangles:

//                                (ax2, ay2)
//       +----------------------------+
//       | A                          |
//       |                            |
//       |                            |
//       |                            |                 (bx2, by2)
//       |          +-----------------+---------------------+
//       |          | OVERLAP         |                     |
//       |          |                 |                     |
//       |          |                 |                     |
//       +----------+-----------------+                     |
//   (ax1, ay1)     |                                       |
//                  |                                       |
//                  |                                     B |
//                  +---------------------------------------+
//              (bx1, by1)

fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
    val areaA = area(ax1, ax2, ay1, ay2)
    val areaB = area(bx1, bx2, by1, by2)

    val overlapX = overlap(ax1, ax2, bx1, bx2)
    val overlapY = overlap(ay1, ay2, by1, by2)
    val overlapArea = overlapX * overlapY

    return areaA + areaB - overlapArea
}

private fun overlap(a1: Int, a2: Int, b1: Int, b2: Int): Int =
    Math.max(0, Math.min(a2, b2) - Math.max(a1, b1))

private fun area(x1: Int, x2: Int, y1: Int, y2: Int): Int =
    (y2 - y1) * (x2 - x1)
