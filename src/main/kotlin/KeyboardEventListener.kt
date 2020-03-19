import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

class KeyboardEventListener(private val tetris: Tetris) : EventHandler<KeyEvent> {
    override fun handle(key: KeyEvent) {
        if (key.code == KeyCode.SPACE) {
            tetris.rotateRight()
        }

        if (key.code == KeyCode.LEFT) {
            tetris.moveCurrentTetrominoLeft()
        }

        if (key.code == KeyCode.RIGHT) {
            tetris.moveCurrentTetrominoRight()
        }

        if (key.code == KeyCode.DOWN) {
            tetris.moveCurrentTetrominoDown()
        }
    }
}