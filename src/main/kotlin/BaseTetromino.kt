import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import java.util.*
import kotlin.collections.ArrayList

open class BaseTetromino(
    private var currentCol: Int,
    private val board: Array<Array<Optional<Color>>>,
    private val color: Color
) : Tetromino {
    private var currentRow = 0
    private var savedToBoard = false
    private val movementHandler = TetrominoMovementHandler()
    private val rotationHandler = TetrominoRotationHandler()
    private val boardHandler = BoardHandler()

    protected var shape: ArrayList<ArrayList<Boolean>> = arrayListOf(arrayListOf())

    override fun moveLeft() {
        if (movementHandler.canMoveLeft(currentCol - 1, currentRow, shape, board)) {
            currentCol--
        }
    }

    override fun moveRight() {
        if (movementHandler.canMoveRight(currentCol + 1, currentRow, shape, board)) {
            currentCol++
        }
    }

    override fun isSavedToBoard(): Boolean {
        return savedToBoard
    }

    override fun canMoveDown(rowOffset: Int): Boolean {
        return canMoveDown(rowOffset, shape)
    }

    override fun canMoveDown(rowOffset: Int, shape: ArrayList<ArrayList<Boolean>>): Boolean {
        return movementHandler.canMoveDown(currentCol, rowOffset, shape, board)
    }

    override fun render(canvas: Canvas, blockSize: Int) {
        val tetrominoRenderer = TetrominoRenderer(currentCol, currentRow, canvas, blockSize, this.shape, color)
        tetrominoRenderer.render()
    }

    override fun moveDown() {
        if (canMoveDown(currentRow + 1)) {
            currentRow++
        } else {
            boardHandler.saveToBoard(
                colOffset = currentCol,
                rowOffset = currentRow,
                shape = shape,
                board = board,
                color = color
            )
            savedToBoard = true
        }
    }

    override fun rotateRight() {
        val newShape = rotationHandler.rotateRight(shape)
        if (canMoveDown(0, newShape)){
            shape =  newShape
        }
    }

    override fun rotateLeft() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}