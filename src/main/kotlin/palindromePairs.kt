//       date: 2022-09-17
//      title: Palindrome Pairs
//        url: https://leetcode.com/problems/palindrome-pairs/
// difficulty: hard
//------------------------------------------------------------------------------

fun palindromePairs(words: Array<String>): List<List<Int>> =
    Helper(words).calculate()

private class MyTrieNode {
    var children: MutableMap<Char, MyTrieNode> = mutableMapOf()
    var index: Int? = null
    var list: MutableList<Int> = mutableListOf()
}

private class Helper(val words: Array<String>) {
    val trie = MyTrieNode()
    val result: MutableList<List<Int>> = mutableListOf()

    init {
        words.withIndex().forEach { addWord(it.index, it.value) }
    }

    private fun addWord(index: Int, word: String) {
        var triePtr: MyTrieNode = trie
        for (i in word.indices.reversed()) {
            val chr = word[i]
            triePtr.children.computeIfAbsent(chr) { MyTrieNode() }

            if (word.isPalindromeUpTo(i)) {
                triePtr.list.add(index)
            }

            triePtr = triePtr.children[chr]!!
        }
        triePtr.list.add(index)
        triePtr.index = index
    }

    private fun search(index: Int) {
        var triePtr: MyTrieNode = trie
        for (j in words[index].indices) {
            if (triePtr.index != null && triePtr.index != index && words[index].isPalindromeStartingFrom(j)) {
                result.add(listOf(index, triePtr.index!!))
            }
            triePtr = triePtr.children[words[index][j]] ?: return
        }
        for (j in triePtr.list) {
            if (index == j) continue
            result.add(listOf(index, j))
        }
    }

    fun calculate(): List<List<Int>> {
        words.indices.forEach { search(it) }
        return result
    }

    //--------------------------------------------------------------------------

    // Checks if the word is palindrome in the interval (i..j)
    private fun String.isPalindrome(start: Int, end: Int): Boolean =
        start >= end || (get(start) == get(end) && isPalindrome(start + 1, end - 1))

    private fun String.isPalindromeUpTo(end: Int): Boolean =
        isPalindrome(0, end)

    private fun String.isPalindromeStartingFrom(start: Int): Boolean =
        isPalindrome(start, lastIndex)

}
