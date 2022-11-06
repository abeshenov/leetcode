//       date: 2022-11-06
//      title: Orderly Queue
//        url: https://leetcode.com/problems/orderly-queue/
// difficulty: hard
//------------------------------------------------------------------------------

// This is a trick question.
//
// - If k = 1, then a move consists of taking the first letter and appending it
//   to the end. This is the cyclic permutation (1,2,...,n), generating
//   a subgroup of order n. We can go through generated permutations
//   and pick the minimum string.
//
// - If k > 1, then we are allowed to put the second character to the end,
//   and shift everything cyclically:
//   c_1 c_2 ... c_n -> c_1 c_3 c_4 ... c_n c_2 -> ... -> c_2 c_1 c_3 ... c_n.
//   This way we obtain the transposition (1,2). Together with the cyclic
//   permutation (1,2,...,n), it generates all S_n.
//   To get the answer, we can sort the characters of s.

fun orderlyQueue(s: String, k: Int): String =
    if (k == 1) {
        s.indices.minOf { i -> s.substring(i) + s.substring(0, i) }
    } else {
        String(s.toCharArray().sortedArray())
    }
