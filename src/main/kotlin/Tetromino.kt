import javafx.scene.canvas.Canvas
import kotlin.collections.ArrayList

interface Tetromino {
    fun isSavedToBoard() : Boolean

    fun render(canvas: Canvas, blockSize: Int)

    fun moveLeft()

    fun moveRight()

    fun moveDown()

    fun rotateRight()

    fun rotateLeft()

    fun canMoveDown(rowOffset: Int): Boolean

    fun canMoveDown(rowOffset: Int, shape: ArrayList<ArrayList<Boolean>>): Boolean
}