import javafx.scene.paint.Color
import java.util.*

class OTetromino(
    currentCol: Int,
    board: Array<Array<Optional<Color>>>,
    color: Color
) : BaseTetromino(currentCol, board, color) {
    init {
        this.shape = arrayListOf(
            arrayListOf(true, true),
            arrayListOf(true, true)
        )
    }
}
