//      title: Reshape the Matrix
//        url: https://leetcode.com/problems/reshape-the-matrix/
// difficulty: easy
//------------------------------------------------------------------------------

fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val matR = mat.size
    val matC = mat[0].size

    return if (matR*matC != r*c) {
        mat
    } else Array(r) { row ->
        IntArray(c) { column ->
            val i = row*c + column
            mat[i / matC][i % matC]
        }
    }
}
