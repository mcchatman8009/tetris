import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color

class TetrominoRenderer(
    private val currentCol: Int,
    private val currentRow: Int,
    private val canvas: Canvas,
    private val blockSize: Int,
    private val shape: ArrayList<ArrayList<Boolean>>,
    private val color: Color
) {

    fun render() {
        var row = 0

        var y = (currentRow * blockSize).toDouble()
        val baseX = (currentCol * blockSize).toDouble()

        while (row < shape.size) {
            var x = baseX
            var col = 0

            while (col < shape[row].size) {

                if (shape[row][col]) {

                    canvas.graphicsContext2D.fill = color
                    canvas.graphicsContext2D.fillRect(x, y, blockSize.toDouble(), blockSize.toDouble())
                }

                x += blockSize

                col++
            }

            y += blockSize

            row++
        }
    }
}