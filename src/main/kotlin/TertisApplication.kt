import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import java.util.*

// 10  x 40
class TertisApplication : Application() {
    override fun start(primaryStage: Stage) {
        val canvas = Canvas(640.0, 480.0)
        val tertis = Tetris(canvas)

        val pane = StackPane(canvas)
        val scene = Scene(pane)
        primaryStage.scene = scene

        scene.onKeyPressed = KeyboardEventListener(tertis)

        primaryStage.show()
        val timer = Timer()
        timer.scheduleAtFixedRate(tertis, 100, 1000 / 10)

    }
}

fun main(args: Array<String>) {
    Application.launch(TertisApplication::class.java, *args)
}
