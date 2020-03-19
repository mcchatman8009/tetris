import javafx.scene.paint.Color
import java.util.*

class LTetromino(
    currentCol: Int,
    board: Array<Array<Optional<Color>>>,
    color: Color
) : BaseTetromino(currentCol, board, color) {
    init {
        this.shape = arrayListOf(
            arrayListOf(true, false),
            arrayListOf(true, false),
            arrayListOf(true, true)
        )
    }
}