import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import java.util.*
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

    //val data: ArrayList<ArrayList<Optional<Color>>>)
//
//    companion object {
//        fun createIShape(color: Color): Tetromino {
//            val data = ArrayList<ArrayList<Optional<Color>>>()
//            data.add(arrayListOf(Optional.of(color), Optional.of(color), Optional.of(color), Optional.of(color)))
//
//            return Tetromino(data)
//        }
//    }
}