import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main extends Application {
    static String musicFile1 = "farming.mp3";
    public static Media farmingMusic = new Media(new File(musicFile1).toURI().toString());
    public static MediaPlayer mediaPlayerStarter = new MediaPlayer(farmingMusic);
    static Image musicOff = new Image("file:images/muzyka0.png");
    static Image musicOn = new Image("file:images/muzyka1.png");
    static boolean isMusicOn = true;
    static ImageView cyberdomek1 = new ImageView(new Image("file:images/cyberDomek.png"));
    static ImageView cyberdomek2 = new ImageView(new Image("file:images/cyberDomek.png"));
    static ImageView cyberdomek3 = new ImageView(new Image("file:images/cyberDomek.png"));
    static ImageView cyberdomek4 = new ImageView(new Image("file:images/cyberDomek.png"));

    static List<ImageView> cyberdomekList = new ArrayList<>();

    static {
        cyberdomekList.add(cyberdomek1);
        cyberdomekList.add(cyberdomek2);
        cyberdomekList.add(cyberdomek3);
        cyberdomekList.add(cyberdomek4);
    }


    static AnchorPane ap1 = new AnchorPane();
    static AnchorPane ap2 = new AnchorPane();
    static AnchorPane ap3 = new AnchorPane();
    static AnchorPane ap4 = new AnchorPane();
    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static Stage stage;
    static Timeline timeline = new Timeline();
    static Scene startScene;
    private Player player;
    static boolean wPressed = false;
    static boolean sPressed = false;
    static boolean dPressed = false;
    static boolean aPressed = false;
    static Phone phone = new Phone();

    static ImageView arrow = phone.Arrow();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        player = new Player(20, 20);
        Scene1();
        stage.show();
        mediaPlayerStarter.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerStarter.play();
        playerPositionUpdate((int) player.getX(), (int) player.getY());
    }

    public void Scene1() {


        cyberdomek1.setFitWidth(150);
        cyberdomek1.setFitHeight(150);
        cyberdomek1.setX(650);
        cyberdomek1.setY(400);
        cyberdomek2.setFitWidth(150);
        cyberdomek2.setFitHeight(150);
        cyberdomek2.setX(800);
        cyberdomek2.setY(100);
        cyberdomek3.setFitWidth(150);
        cyberdomek3.setFitHeight(150);
        cyberdomek3.setX(400);
        cyberdomek3.setY(200);
        cyberdomek4.setFitWidth(150);
        cyberdomek4.setFitHeight(150);
        cyberdomek4.setX(100);
        cyberdomek4.setY(100);

        Target target = new Target();
        target.setTargetToRandom(cyberdomekList);

        ImageView wyjdzZGry = new ImageView(new Image("file:images/wyjdzZGry.png"));
        wyjdzZGry.setLayoutX(1050);
        wyjdzZGry.setLayoutY(7);
        wyjdzZGry.setFitHeight(40);
        wyjdzZGry.setFitWidth(140);

        ImageView musicOnOffButton = new ImageView(musicOn);
        musicOnOffButton.setLayoutX(952);
        musicOnOffButton.setLayoutY(7);
        musicOnOffButton.setFitWidth(90);
        musicOnOffButton.setFitHeight(40);

        musicOnOffButton.setOnMouseClicked(event -> {
            if (!isMusicOn) {
                musicOnOffButton.setImage(musicOff);
                isMusicOn = true;
                mediaPlayerStarter.setMute(true);
            } else {
                musicOnOffButton.setImage(musicOn);
                isMusicOn = false;
                mediaPlayerStarter.setMute(false);
            }
        });
        phone.RotateArrow(player.getX(), player.getY(), cyberdomek1.getX(), cyberdomek1.getY());

        ap1.getChildren().addAll(musicOnOffButton, wyjdzZGry, cyberdomek1, cyberdomek2, cyberdomek3, cyberdomek4, player.imageView, phone, arrow);

        startScene = new Scene(ap1, WIDTH, HEIGHT);
        stage.setTitle("Ekran główny");
        stage.setScene(startScene);
        startScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                wPressed = true;
            }
            if (event.getCode() == KeyCode.S) {
                sPressed = true;
            }
            if (event.getCode() == KeyCode.A) {
                aPressed = true;
            }
            if (event.getCode() == KeyCode.D) {
                dPressed = true;
            }
        });
        startScene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W) {
                wPressed = false;
            }
            if (event.getCode() == KeyCode.S) {
                sPressed = false;
            }
            if (event.getCode() == KeyCode.A) {
                aPressed = false;
            }
            if (event.getCode() == KeyCode.D) {
                dPressed = false;
            }
        });

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(16), e -> {
            int dy = 0;
            int dx = 0;

            if (wPressed) {
                dy = -2;
            }
            if (sPressed) {
                dy = 2;
            }
            if (dPressed) {
                dx = +2;
            }
            if (aPressed) {
                dx = -2;
            }
            player.imageView.setX(player.imageView.getX() + dx);
            player.imageView.setY(player.imageView.getY() + dy);


            if (player.imageView.intersects(cyberdomek1.getBoundsInParent()) || player.imageView.intersects(cyberdomek2.getBoundsInParent()) || player.imageView.intersects(cyberdomek3.getBoundsInParent()) || player.imageView.intersects(cyberdomek4.getBoundsInParent())) {
                player.imageView.setX(player.imageView.getX() - dx);
                player.imageView.setY(player.imageView.getY() - dy);
                wPressed = false;
                sPressed = false;
                dPressed = false;
                aPressed = false;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        stage.setTitle("Ekran główny");
        stage.setScene(startScene);


        wyjdzZGry.setOnMouseClicked(event -> handleExitGame(stage));
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

    public static void playerPositionUpdate(int xPlayer, int yPlayer) {
        if (stage.getScene().getRoot().equals(ap1)) {
        } else if (stage.getScene().getRoot().equals(ap2)) {
        } else if (stage.getScene().getRoot().equals(ap3)) {
        } else if (stage.getScene().getRoot().equals(ap4)) {
        }
    }
}