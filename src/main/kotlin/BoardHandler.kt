import javafx.scene.paint.Color
import java.util.*
import kotlin.collections.ArrayList

class BoardHandler {

    fun saveToBoard(
        colOffset: Int,
        rowOffset: Int,
        shape: ArrayList<ArrayList<Boolean>>,
        board: Array<Array<Optional<Color>>>,
        color: Color
    ) {

        var shapeRow = 0

        while (shapeRow < shape.size) {

            var shapeCol = 0
            while (shapeCol < shape[shapeRow].size) {

                if (shape[shapeRow][shapeCol]) {
                    board[rowOffset + shapeRow][colOffset + shapeCol] = Optional.ofNullable(color)
                }

                shapeCol++
            }

            shapeRow++
        }

    }
}