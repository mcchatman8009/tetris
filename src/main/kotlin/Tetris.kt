import javafx.application.Platform
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import java.util.*
import kotlin.random.Random

class Tetris(private val canvas: Canvas) : TimerTask() {
    private val board = TetrisBoard(boardColor = Color.BLACK, blockSize = BLOCK_SIZE)
    private val tetrominoFactory: List<(Int) -> Tetromino> = listOf(
        { col -> ITetromino(col, board.getBoardArray(), Color.RED)},
        { col -> JTetromino(col, board.getBoardArray(), Color.BLUE)},
        { col -> LTetromino(col, board.getBoardArray(), Color.GREEN)},
        { col -> OTetromino(col, board.getBoardArray(), Color.YELLOW)},
        { col -> STetromino(col, board.getBoardArray(), Color.BROWN)},
        { col -> TTetromino(col, board.getBoardArray(), Color.PURPLE)},
        { col -> ZTetromino(col, board.getBoardArray(), Color.ORANGE)}
    )
    private val numTetrominoTypes = tetrominoFactory.size

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
        val i = Random.nextInt(until = numTetrominoTypes)
        val col = Random.nextInt(until = TetrisBoard.BOARD_COLUMNS - 4)

        return tetrominoFactory[i](col)
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
