import javafx.scene.paint.Color
import java.util.*

class TTetromino(
    currentCol: Int,
    board: Array<Array<Optional<Color>>>,
    color: Color
) : BaseTetromino(currentCol, board, color) {
    init {
        this.shape = arrayListOf(
            arrayListOf(true, true, true),
            arrayListOf(false, true, false)
        )
    }
}
