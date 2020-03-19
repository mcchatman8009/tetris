import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import java.util.*

class Tertis(private val canvas: Canvas) : TimerTask() {
    private var currentTermino = Optional.empty<Tetromino>()
    private var gameOver = false

    private val board = Array(BOARD_ROWS) {
        Array<Optional<Color>>(BOARD_COLUMNS) { Optional.empty() }
    }

    override fun run() {
        update()
        render()
    }


    private fun spawnNewTeromino(): Tetromino {
        val iTetromino = LTetromino(0, board, Color.RED)

        return iTetromino
    }

    private fun update() {
        updateCurrentTermino()
    }

    private fun updateCurrentTermino() {
        if (!currentTermino.isPresent) {
            currentTermino = Optional.ofNullable(spawnNewTeromino())
        }

        currentTermino.map {
            if (it.isSavedToBoard()) {
                currentTermino = Optional.ofNullable(spawnNewTeromino())
            } else if (!it.canMoveDown(0)) {
                gameOver = true
            } else {
                it.moveDown()
            }
        }
    }

    private fun renderCurrentTermino() {
        currentTermino.map { it.render(canvas, BLOCK_SIZE.toInt()) }
    }

    private fun render() {
        renderBoard()
        renderCurrentTermino()
    }


    private fun renderBoard() {
        val ctx = canvas.graphicsContext2D

        for (row in 0 until BOARD_ROWS) {
            for (col in 0 until BOARD_COLUMNS) {
                val y = row * BLOCK_SIZE.toDouble()
                val x = col * BLOCK_SIZE.toDouble()

                if (board[row][col].isPresent) {
                    ctx.fill = board[row][col].get()
                } else {
                    ctx.fill = Color.BLACK
                }

                ctx.fillRect(x, y, BLOCK_SIZE.toDouble(), BLOCK_SIZE.toDouble())
            }

        }
    }

    companion object {
        private const val BLOCK_SIZE = 10
        private const val BOARD_COLUMNS = 10
        private const val BOARD_ROWS = 16
    }
}