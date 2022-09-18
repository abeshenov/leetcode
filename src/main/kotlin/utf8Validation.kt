//       date: 2022-09-13
//      title: UTF-8 Validation
//        url: https://leetcode.com/problems/utf-8-validation/
// difficulty: medium
//------------------------------------------------------------------------------

//    Number of Bytes  |        UTF-8 Octet Sequence
//                     |              (binary)
// --------------------+-----------------------------------------
//          1          |   0xxxxxxx
//          2          |   110xxxxx 10xxxxxx
//          3          |   1110xxxx 10xxxxxx 10xxxxxx
//          4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

// The first byte carries the required information

fun validUtf8(data: IntArray): Boolean {
    val iterator = data.iterator()

    while (iterator.hasNext()) {
        val byte = iterator.next()
        val characterType = characterType(byte) ?: return false

        for (i in 2  .. characterType) {
            if (!iterator.hasNext() || !isGoodIntermediateByte(iterator.next())) {
                return false
            }
        }
    }

    return true
}

private fun characterType(byte: Int): Int? =
    when {
        byte and 0b10000000 == 0 -> 1
        byte and 0b00100000 == 0 && byte and 0b11000000 == 0b11000000 -> 2
        byte and 0b00010000 == 0 && byte and 0b11100000 == 0b11100000 -> 3
        byte and 0b00001000 == 0 && byte and 0b11110000 == 0b11110000 -> 4
        else -> null
    }

private fun isGoodIntermediateByte(byte: Int): Boolean =
    byte and 0b01000000 == 0 && byte and 0b10000000 == 0b10000000
