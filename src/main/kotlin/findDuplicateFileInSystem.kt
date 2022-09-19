//       date: 2022-09-19
//      title: Find Duplicate File in System
//        url: https://leetcode.com/problems/find-duplicate-file-in-system/
// difficulty: medium
//------------------------------------------------------------------------------

fun findDuplicate(paths: Array<String>): List<List<String>> =
    DuplicateHelper(paths).duplicates()

private class DuplicateHelper(paths: Array<String>) {
    // Will store (content) --> (list of full paths with given content)
    val contentsMap: MutableMap<String, MutableList<String>> = mutableMapOf()

    init {
        paths.forEach(::registerEntry)
    }

    fun duplicates(): List<List<String>> =
        contentsMap.values.filter { it.size > 1 }.toList()

    // Example input is a list of entries of the form
    //   "root/a 1.txt(abcd) 2.txt(efgh)"
    //   "root/c 3.txt(abcd)"
    //   "root/c/d 4.txt(efgh)"
    private fun registerEntry(entry: String) {
        val fields: List<String> = entry.split(' ')
        val rootDir = fields[0]

        for (fieldText in fields.slice(1..fields.lastIndex)) {
            val field = Regex("(.+)\\((.+)\\)")
                .matchEntire(fieldText)!!.groupValues

            registerEntry(rootDir + "/" + field[1], field[2])
        }
    }

    private fun registerEntry(path: String, contents: String) {
        contentsMap.computeIfAbsent(contents) { mutableListOf() }
        contentsMap[contents]!!.add(path)
    }

}
