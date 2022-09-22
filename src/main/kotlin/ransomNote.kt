//      title: Ransom Note
//        url: https://leetcode.com/problems/ransom-note/
// difficulty: easy
//------------------------------------------------------------------------------

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val letterFreq: MutableMap<Char, Int> = mutableMapOf()

    for (chr in magazine) {
        letterFreq[chr] = letterFreq.getOrDefault(chr, 0) + 1
    }

    for (chr in ransomNote) {
        val frequency = letterFreq[chr]
        if (frequency == null || frequency == 0) {
            return false
        } else {
            letterFreq[chr] = frequency - 1
        }
    }

    return true
}
