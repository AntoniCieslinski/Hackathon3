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

    static CyberDomek cyberdomek1 = new CyberDomek();
    static CyberDomek cyberdomek2 = new CyberDomek();
    static CyberDomek cyberdomek3 = new CyberDomek();
    static CyberDomek cyberdomek4 = new CyberDomek();

//    static List<ImageView> cyberdomekList = new ArrayList<>();

    static List<CyberDomek> cyberdomekList = new ArrayList<>();
    static {
        cyberdomekList.add(cyberdomek1);
        cyberdomekList.add(cyberdomek2);
        cyberdomekList.add(cyberdomek3);
        cyberdomekList.add(cyberdomek4);
    }

    static AnchorPane ap1 = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static Stage stage;
    static Timeline timeline = new Timeline();
    static Scene startScene;
    static Player player;
    static Sheep owca1;
    static Sheep owca2;
    static Sheep owca3;
    static Sheep owca4;

    static boolean wPressed = false;
    static boolean sPressed = false;
    static boolean dPressed = false;
    static boolean aPressed = false;

    static Phone phone = new Phone();
    static ImageView arrow = phone.Arrow();

    static int whichMap = 1;
    static Image map1 = new Image("file:images/mapa/1.png");
    static Image map2 = new Image("file:images/mapa/2.png");
    static Image map3 = new Image("file:images/mapa/3.png");
    static Image map4 = new Image("file:images/mapa/4.png");
    static ImageView map = new ImageView(map1);

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
        cyberdomek3.setY(550);
        cyberdomek4.setFitWidth(150);
        cyberdomek4.setFitHeight(150);
        cyberdomek4.setX(100);
        cyberdomek4.setY(100);
//
//        CyberDomek.generateTheFourDomki();

//        if (Main.cyberdomekList.size() >= 4) {
//            cyberdomek1 = Main.cyberdomekList.get(0);
//            cyberdomek2 = Main.cyberdomekList.get(1);
//            cyberdomek3 = Main.cyberdomekList.get(2);
//            cyberdomek4 = Main.cyberdomekList.get(3);
//        }

        Target target = new Target();
        target.setTargetToRandom(cyberdomekList);

        //owce dodawanie
        if (cyberdomekList.size() >= 4) {
            owca1 = new Sheep((int) cyberdomekList.get(0).getX(), (int) cyberdomekList.get(0).getY());
            owca2 = new Sheep((int) cyberdomekList.get(1).getX(), (int) cyberdomekList.get(1).getY());
            owca3 = new Sheep((int) cyberdomekList.get(2).getX(), (int) cyberdomekList.get(2).getY());
            owca4 = new Sheep((int) cyberdomekList.get(3).getX(), (int) cyberdomekList.get(3).getY());
        }

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
            phone.RotateArrow(player.imageView.getX(), player.imageView.getY(),target.getCenterX(), target.getCenterY());
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
            changeMap();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        ap1.getChildren().addAll(map, musicOnOffButton, wyjdzZGry,  target, cyberdomek1, cyberdomek2, cyberdomek3, cyberdomek4, player.imageView, phone, arrow, owca1, owca2, owca3, owca4);

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

    public static void changeMap(){
        // adjust to player width/height zeby bylo idealnie

        //mapa 1 jesteśmy

        if(whichMap == 1){
            map.setImage(map1);
            //zmiana na map 2
            if(player.imageView.getX() + player.imageView.getFitWidth() > WIDTH){
                whichMap = 2;
                map.setImage(map2);
                player.imageView.setX(player.imageView.getFitWidth());
            }
            //zmiana na map4
            if(player.imageView.getY()  < 0){
                whichMap = 4;
                cyberdomek1.setX(200);
                cyberdomek1.setY(200);
                cyberdomek2.setX(800);
                cyberdomek2.setX(100);
                cyberdomek3.setX(600);
                cyberdomek3.setY(600);
                cyberdomek4.setX(800);
                cyberdomek4.setY(700);
                System.out.println("change to map 4");
                map.setImage(map4);
                player.imageView.setY(HEIGHT - player.imageView.getFitHeight());
            }

            //nie wychodzenie
            if(player.imageView.getX() <0){
                player.imageView.setX(0);
            }
            if(player.imageView.getY() + player.imageView.getFitHeight() > HEIGHT){
                player.imageView.setY(HEIGHT - player.imageView.getFitHeight());
            }
        }
        //mapa 2 jesteśmy
        else if(whichMap == 2){
            map.setImage(map2);
            //zmiana na map 1
            if(player.imageView.getX() < 0){
                whichMap = 1;
                map.setImage(map1);
                player.imageView.setX(WIDTH - player.imageView.getFitWidth() - 10);
            }
            //zmiana na map 3
            if(player.imageView.getY() < 0){
                whichMap = 3;
                map.setImage(map3);
                player.imageView.setY(HEIGHT - player.imageView.getFitHeight());
            }
            //nie wychodzenie
            if(player.imageView.getX() + player.imageView.getFitWidth() > WIDTH){
                player.imageView.setX(WIDTH - player.imageView.getFitWidth());
            }
            if(player.imageView.getY() + player.imageView.getFitHeight() > HEIGHT){
                player.imageView.setY(HEIGHT - player.imageView.getFitHeight());
            }
        }
        //mapa 3 jesteśmy
        else if(whichMap == 3){
            map.setImage(map3);
            //zmiana na map 2
            if(player.imageView.getY() + player.imageView.getFitHeight()> HEIGHT){
                whichMap = 2;
                map.setImage(map2);
                player.imageView.setY( player.imageView.getFitHeight());
            }
            //zmiana na map 4
            if(player.imageView.getX()< 0){
                whichMap = 4;
                map.setImage(map4);
                player.imageView.setX(WIDTH - player.imageView.getFitWidth());
            }

            //nie wychodzenie
            if(player.imageView.getX() + player.imageView.getFitWidth() > WIDTH){
                player.imageView.setX(WIDTH - player.imageView.getFitWidth());
            }
            if(player.imageView.getY() < 0){
                player.imageView.setY(0);
            }

        }
        //mapa 4 jesteśmy >>>>
        else if(whichMap == 4){
            map.setImage(map4);
            //zmiana na map 1
            if(player.imageView.getY() + player.imageView.getFitHeight() > HEIGHT){
                whichMap = 1;
                map.setImage(map1);
                player.imageView.setY(player.imageView.getFitHeight());
            }
            //zmiana na map 3
            if(player.imageView.getX() + player.imageView.getFitWidth()> WIDTH){
                whichMap = 3;
                map.setImage(map3);
                player.imageView.setX(player.imageView.getFitWidth());
            }

            //nie wychodzenie
            if(player.imageView.getX() < 0){
                player.imageView.setX(0);
            }
            if(player.imageView.getY() < 0){
                player.imageView.setY(0);
            }
        }
        map.setFitWidth(1200);
        map.setFitHeight(800);
    }


    public static void playerPositionUpdate(int xPlayer, int yPlayer){
        if (stage.getScene().getRoot().equals(ap1)){
        }
    }

//    public void generateCyberDomekPosition(){
//        double newX = Math.random()*1200;
//        double newY = Math.random()*800;
//
//        if ()
//
//    }
}