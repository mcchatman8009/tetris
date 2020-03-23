import javafx.scene.paint.Color
import java.util.*

class STetromino(
    currentCol: Int,
    board: Array<Array<Optional<Color>>>,
    color: Color
) : BaseTetromino(currentCol, board, color) {
    init {
        this.shape = arrayListOf(
            arrayListOf(false, true, true),
            arrayListOf(true, true, false)
        )
    }
}
