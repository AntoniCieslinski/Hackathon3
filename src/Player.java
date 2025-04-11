import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Player extends ImageView {

    int x;
    int y;
    boolean isDown;

    static Image imageView = new Image("file:images/phone.png");

    public Player(int x, int y) {

        super(imageView);
        this.x = x;
        this.y = y;

        Main.startScene.setOnKeyPressed(event1 -> {

            if (event1.getCode() == KeyCode.DOWN) {
                setLayoutY(getLayoutY()+10);
            }
            if (event1.getCode() == KeyCode.UP) {
                setLayoutY(getLayoutY()-10);
            }
            if (event1.getCode() == KeyCode.LEFT) {
                setLayoutX(getLayoutX()-10);
            }
            if (event1.getCode() == KeyCode.RIGHT) {
                setLayoutX(getLayoutX()+10);
            }

        });

    }

    Timeline timelinePlayer = new Timeline(new KeyFrame(Duration.millis(10), event -> {




    }));



    public boolean isDown() {
        return isDown;
    }


}
