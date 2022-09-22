//       date: 2022-09-22
//      title: Reverse Words in a String III
//        url: https://leetcode.com/problems/reverse-words-in-a-string-iii/
// difficulty: easy
//------------------------------------------------------------------------------

// This is cheating, but we can also reimplement things from scratch :-)
fun reverseWords(s: String): String =
    s.split(" ").joinToString(" ") { it.reversed() }

// Two pointer approach
fun reverseWordsTwoPointers(s: String): String {
    val bytes: ByteArray = s.toByteArray()

    var i = 0
    while (i < bytes.size) {
        var j = i

        // Make j point to the place after the word end :
        while (j < bytes.size && bytes[j] != ' '.code.toByte()) {
            j++
        }

        inPlaceReverse(bytes, i, j - 1)

        i = j + 1
    }

    return String(bytes)
}

private tailrec fun inPlaceReverse(arr: ByteArray, start: Int = 0, end: Int = arr.lastIndex) {
    if ((0 <= start) && (start < end) && (end < arr.size)) {
        val tmp = arr[start]
        arr[start] = arr[end]
        arr[end] = tmp

        inPlaceReverse(arr, start + 1, end - 1)
    }
}
