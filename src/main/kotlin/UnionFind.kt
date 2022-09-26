// https://en.wikipedia.org/wiki/Disjoint-set_data_structure

class UnionFind<T>(elements: Set<T>) {
    private val parentMap: MutableMap<T, T> = mutableMapOf()
    private val rankMap: MutableMap<T, Int> = mutableMapOf()

    init {
        elements.forEach { add(it) }
    }

    private fun add(x: T): Boolean {
        if (parentMap.containsKey(x)) {
            return false
        }

        parentMap[x] = x
        rankMap[x] = 0

        return true
    }

    private fun find(x: T): T {
        var root = x

        while (parentMap[root] != root) {
            root = parentMap[root]!!
        }

        var current = x

        while (parentMap[current] != root) {
            val parent = parentMap[current]!!
            parentMap[current] = root
            current = parent
        }

        return root
    }

    fun union(x: T, y: T) {
        if (!parentMap.containsKey(x) || !parentMap.containsKey(y))  {
            throw IllegalArgumentException("elements must be contained in given set")
        }

        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) {
            return
        }

        val rankX = rankMap[rootX]!!
        val rankY = rankMap[rootY]!!

        if (rankX > rankY) {
            parentMap[rootY] = rootX
        } else if (rankX < rankY) {
            parentMap[rootX] = rootY
        } else {
            parentMap[rootY] = rootX
            rankMap[rootX] = rankX + 1
        }

    }

    fun inSameSet(element1: T, element2: T): Boolean =
        find(element1) == find(element2)

}
