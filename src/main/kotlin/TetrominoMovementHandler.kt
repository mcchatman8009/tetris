import javafx.scene.paint.Color
import java.util.*
import kotlin.collections.ArrayList

class TetrominoMovementHandler {
    fun canMoveDown(
        colOffset: Int,
        rowOffset: Int,
        shape: ArrayList<ArrayList<Boolean>>,
        board: Array<Array<Optional<Color>>>
    ): Boolean {
        for (row in 0 until shape.size) {
            for (col in 0 until shape[row].size) {
                if (row + rowOffset >= board.size) {
                    return false
                }

                if (board[row + rowOffset][col + colOffset].isPresent) {
                    return false
                }

            }
        }

        return true
    }

    fun canMoveRight(
        colOffset: Int,
        rowOffset: Int,
        shape: ArrayList<ArrayList<Boolean>>,
        board: Array<Array<Optional<Color>>>
    ): Boolean {
        for (row in 0 until shape.size) {
            for (col in 0 until shape[row].size) {
                if (colOffset + col >= board[0].size) {
                    return false
                }
                if (board[row + rowOffset][col + colOffset].isPresent) {
                    return false
                }

            }
        }

        return true
    }

    fun canMoveLeft(
        colOffset: Int,
        rowOffset: Int,
        shape: ArrayList<ArrayList<Boolean>>,
        board: Array<Array<Optional<Color>>>
    ): Boolean {
        for (row in 0 until shape.size) {
            for (col in 0 until shape[row].size) {
                if (colOffset + col < 0) {
                    return false
                }
                if (board[row + rowOffset][col + colOffset].isPresent) {
                    return false
                }

            }
        }

        return true

    }

}