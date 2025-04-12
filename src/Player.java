import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

    public double x;
    public double y;
    private boolean isDown;
    ImageView imageView = new ImageView(new Image("file:images/farmer/1.png"));

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }
}
