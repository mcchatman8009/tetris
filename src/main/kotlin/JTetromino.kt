import javafx.scene.paint.Color
import java.util.*

class JTetromino(
    currentCol: Int,
    board: Array<Array<Optional<Color>>>,
    color: Color
) : BaseTetromino(currentCol, board, color) {
    init {
        this.shape = arrayListOf(
            arrayListOf(false, true),
            arrayListOf(false, true),
            arrayListOf(true, true)
        )
    }
}
