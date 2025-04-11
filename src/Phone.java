import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Phone extends ImageView {
    static int rotate = 90;

    public Phone() {
        super(new Image("file:images/phone.png"));
        setFitWidth(216);
        setFitHeight(288);
        setX(10);
        setY(Main.HEIGHT - 298);
    }
    public ImageView Arrow(){
        ImageView arrow = new ImageView(new Image("file:images/redArrow.png"));
        arrow.setFitWidth(62);
        arrow.setFitHeight(35);
        arrow.setX(85);
        arrow.setY(583);
        arrow.setRotate(rotate);
        return arrow;
    }

    public void RotateArrow(int playerX, int playerY, int targetX, int targetY){
        int opposite = targetY - playerY;
        int adjacent = targetX - playerX;

        double angle = Math.atan(opposite/adjacent);
    }
}
