//      title: Implement Trie (Prefix Tree)
//        url: https://leetcode.com/problems/implement-trie-prefix-tree/
// difficulty: medium

class Trie {
    private val root: TrieNode = TrieNode()

    private data class TrieNode(
        val children: MutableMap<Char,TrieNode> = mutableMapOf(),
        var isWord: Boolean = false
    )

    fun insert(word: String) {
        var nodePtr: TrieNode = root

        for (chr in word) {
            nodePtr.children.computeIfAbsent(chr) { TrieNode() }
            nodePtr = nodePtr.children[chr]!!
        }

        nodePtr.isWord = true
    }

    fun search(word: String): Boolean {
        var nodePtr: TrieNode = root

        for (chr in word) {
            if (nodePtr.children[chr] == null) {
                return false
            }
            nodePtr = nodePtr.children[chr]!!
        }

        return nodePtr.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var nodePtr: TrieNode = root

        for (chr in prefix) {
            if (nodePtr.children[chr] == null) {
                return false
            }
            nodePtr = nodePtr.children[chr]!!
        }

        return true
    }
}
