import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
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

    static AnchorPane ap1 = new AnchorPane();
    static AnchorPane ap2 = new AnchorPane();
    static AnchorPane ap3 = new AnchorPane();
    static AnchorPane ap4 = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static Stage stage;
    static Timeline timeline = new Timeline();

    static Scene startScene;

    static Phone phone = new Phone();

    static ImageView arrow = phone.Arrow();

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
        Player player = new Player(20, 20);
        
        playerPositionUpdate(player.x, player.y);
    }

    public void Scene1() {
        cyberdomek1.setFitWidth(200);
        cyberdomek1.setFitHeight(200);
        cyberdomek2.setFitWidth(200);
        cyberdomek2.setFitHeight(200);
        cyberdomek3.setFitWidth(200);
        cyberdomek3.setFitHeight(200);
        cyberdomek4.setFitWidth(200);
        cyberdomek4.setFitHeight(200);
        cyberdomek1.setX(650);
        cyberdomek1.setY(400);
        cyberdomek2.setX(800);
        cyberdomek2.setY(100);
        cyberdomek3.setX(400);
        cyberdomek3.setY(200);
        cyberdomek4.setX(100);
        cyberdomek4.setY(100);

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


        ap1.getChildren().addAll(musicOnOffButton, wyjdzZGry, phone, arrow, cyberdomek1, cyberdomek2, cyberdomek3, cyberdomek4);

        Scene startScene = new Scene(ap1, WIDTH, HEIGHT);
//        startScene.setOnMouseClicked(event -> {
//            double sceneX = event.getSceneX(); // X relative to the scene
//            double sceneY = event.getSceneY();
//            System.out.println(sceneX);
//            System.out.println(sceneY);
//        });
        stage.setTitle("Ekran główny");
        stage.setScene(startScene);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(16), e -> {
            startScene.setOnKeyPressed((KeyEvent event) -> {
                switch (event.getCode()) {
                    case LEFT:
                        Phone.rotate -= 10;
                        arrow.setRotate(Phone.rotate);
                        break;
                    case RIGHT:
                        Phone.rotate += 10;
                        break;
                    default:
                        System.out.println("Other key pressed: " + event.getCode());
                }
            });
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


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

    public static void playerPositionUpdate(int xPlayer, int yPlayer){
        if (stage.getScene().getRoot().toString().equals("ap1")){
            System.out.println("this bitch");
        }
        else if (stage.getScene().getRoot().toString().equals("ap2")){

        }
        else if (stage.getScene().getRoot().toString().equals("ap3")){

        }
        else if (stage.getScene().getRoot().toString().equals("ap4")){

        }
        else if (stage.getScene().getRoot().toString().equals("ap5")){

        }
        else if (stage.getScene().getRoot().toString().equals("ap6")){

        }
    }
}