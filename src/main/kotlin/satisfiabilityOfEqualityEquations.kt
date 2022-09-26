//       date: 2022-09-26
//      title: Satisfiability of Equality Equations
//        url: https://leetcode.com/problems/satisfiability-of-equality-equations/
// difficulty: medium
//------------------------------------------------------------------------------

// Using UnionFind.kt
fun equationsPossible(equations: Array<String>): Boolean {
    val unionFind: UnionFind<Char> = UnionFind(('a'..'z').toSet())

    for (equation in equations.filter { it.substring(1, 3) == "==" }) {
        val firstVar = equation[0]
        val secondVar = equation[3]
        unionFind.union(firstVar, secondVar)
    }

    for (equation in equations.filter { it.substring(1, 3) == "!=" }) {
        val firstVar = equation[0]
        val secondVar = equation[3]
        if (unionFind.inSameSet(firstVar, secondVar)) {
            return false
        }
    }

    return true
}
