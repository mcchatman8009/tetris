import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import java.util.*

class TetrisBoard(private val boardColor: Color, private val blockSize: Int) {
    private val board = Array(BOARD_ROWS) {
        Array<Optional<Color>>(BOARD_COLUMNS) { Optional.empty() }
    }

    fun getBoardArray(): Array<Array<Optional<Color>>> {
        return board
    }

    fun render(canvas: Canvas) {
        val ctx = canvas.graphicsContext2D

        for (row in 0 until BOARD_ROWS) {
            for (col in 0 until BOARD_COLUMNS) {
                val y = row * blockSize.toDouble()
                val x = col * blockSize.toDouble()

                if (board[row][col].isPresent) {
                    ctx.fill = board[row][col].get()
                } else {
                    ctx.fill = boardColor
                }

                ctx.fillRect(x, y, blockSize.toDouble(), blockSize.toDouble())
            }

        }
    }

    companion object {
        private const val BOARD_COLUMNS = 10
        private const val BOARD_ROWS = 16
    }
}