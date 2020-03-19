import javafx.application.Platform
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import java.util.*

class Tetris(private val canvas: Canvas) : TimerTask() {
    private val board = TetrisBoard(boardColor = Color.BLACK, blockSize = BLOCK_SIZE)
    private var currentTermino = Optional.empty<Tetromino>()
    private var gameOver = false


    override fun run() {
        update()
        render()
    }

    fun moveCurrentTetrominoLeft() {
        currentTermino.map { it.moveLeft() }
    }

    fun moveCurrentTetrominoRight() {
        currentTermino.map { it.moveRight() }
    }

    fun moveCurrentTetrominoDown() {
        currentTermino.map { it.moveRight() }
    }

    fun rotateRight() {
        currentTermino.map { it.rotateRight() }
    }

    fun rotateLeft() {
        currentTermino.map { it.rotateLeft() }
    }

    private fun spawnNewTeromino(): Tetromino {
        val iTetromino = LTetromino(0, board.getBoardArray(), Color.RED)

        return iTetromino
    }

    private fun render() {
        Platform.runLater {
            renderBoard()
            renderCurrentTermino()
        }
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
        currentTermino.map { it.render(canvas, BLOCK_SIZE) }
    }

    private fun renderBoard() {
        board.render(canvas)
    }

    companion object {
        private const val BLOCK_SIZE = 10
    }
}