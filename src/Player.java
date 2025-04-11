import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player extends ImageView {

    int x;
    int y;
    boolean isDown;

    public Player(Image imageView, int x, int y) {
        super(imageView);
        this.x = x;
        this.y = y;

    }

    Timeline timelinePlayer = new Timeline(new KeyFrame(Duration.millis(10), event -> {


    }));



    public boolean isDown() {
        return isDown;
    }


}
