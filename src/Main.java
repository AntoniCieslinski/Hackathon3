import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class Main extends Application {

    static String musicFile1 = "farming.mp3";
    public static Media farmingMusic = new Media(new File(musicFile1).toURI().toString());
    public static MediaPlayer mediaPlayerStarter = new MediaPlayer(farmingMusic);

    static Image musicOff = new Image("file:images/muzyka0.png");
    static Image musicOn = new Image("file:images/muzyka1.png");
    static boolean isMusicOn = true;

    static AnchorPane ap1 = new AnchorPane();
    static AnchorPane ap2 = new AnchorPane();
    static AnchorPane ap3 = new AnchorPane();
    static AnchorPane ap4 = new AnchorPane();
    static AnchorPane ap5 = new AnchorPane();
    static AnchorPane ap6 = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Scene1();
        stage.show();
        mediaPlayerStarter.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerStarter.play();
    }

    public void Scene1() {

        ImageView wyjdzZGry = new ImageView(new Image("file:images/wyjdzZGry.png"));
        wyjdzZGry.setLayoutX(820);
        wyjdzZGry.setLayoutY(10);
        wyjdzZGry.setFitHeight(50);
        wyjdzZGry.setFitWidth(150);

        ImageView musicOnOffButton = new ImageView(musicOn);
        musicOnOffButton.setLayoutX(618);
        musicOnOffButton.setLayoutY(50);
        isMusicOn = true;

        musicOnOffButton.setOnMouseClicked(event -> {
            if(isMusicOn == false){
                musicOnOffButton.setImage(musicOff);
                isMusicOn = true;
                mediaPlayerStarter.setMute(true);

            } else {
                musicOnOffButton.setImage(musicOn);
                isMusicOn = false;
                mediaPlayerStarter.setMute(false);
            }
        });

        ap1.getChildren().addAll(musicOnOffButton, wyjdzZGry);

        Scene startScene = new Scene(ap1, WIDTH, HEIGHT);
        stage.setTitle("Ekran główny");
        stage.setScene(startScene);

        wyjdzZGry.setOnMouseClicked(event -> {
            handleExitGame(stage);
        });
    }

    private static void handleExitGame(Stage stageMenu) {
        stageMenu.setAlwaysOnTop(false);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Czy na pewno chcesz wyjść z gry?");
        alert.setTitle("");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage.close();
            stageMenu.close();
        } else {
            alert.close();
        }
    }
}