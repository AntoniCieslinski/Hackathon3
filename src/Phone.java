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

    public void RotateArrow(double playerX, double playerY, double targetX, double targetY){
        double opposite = targetY - playerY;
        double adjacent = targetX - playerX;

        double angle = Math.atan2(opposite, adjacent);
        //System.out.println(angle);

        Main.arrow.setRotate(Math.toDegrees(angle) +180);
        //System.out.println(Main.arrow.getRotate());
    }
}
