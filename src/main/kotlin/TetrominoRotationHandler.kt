class TetrominoRotationHandler {
    fun rotateRight(shape: ArrayList<ArrayList<Boolean>>): ArrayList<ArrayList<Boolean>> {
        val cols = shape.first().size
        val rows = shape.size
        var i = 0
        val newShape = ArrayList<ArrayList<Boolean>>()

        while (i < cols) {
            newShape.add(ArrayList())
            var j = 0

            while (j < rows) {
                val value = shape[rows - j - 1][i]
                newShape[i].add(value)

                j++
            }
            i++
        }

        return newShape
    }

}