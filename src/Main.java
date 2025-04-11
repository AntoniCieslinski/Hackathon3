import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    static String musicFile1 = "farming.mp3";
    public static Media farmingMusic = new Media(new File(musicFile1).toURI().toString());
    public static MediaPlayer mediaPlayerStarter = new MediaPlayer(farmingMusic);

    static AnchorPane root = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mediaPlayerStarter.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerStarter.play();

        stage = primaryStage;

        Scene startScene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Ekran główny");
        stage.setScene(startScene);
        stage.show();

    }
}