import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

class KeyboardEventListener(private val tetris: Tertis) : EventHandler<KeyEvent> {
    override fun handle(key: KeyEvent) {
        if (key.getCode() == KeyCode.SPACE) {
            tetris.rotateRight()
        }

        if (key.getCode() == KeyCode.LEFT) {
            tetris.moveCurrentTetrominoLeft()
        }

        if (key.getCode() == KeyCode.RIGHT) {
            tetris.moveCurrentTetrominoRight()
        }

        if (key.getCode() == KeyCode.DOWN) {
            tetris.moveCurrentTetrominoDown()
        }
    }
}