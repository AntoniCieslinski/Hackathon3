import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Phone extends ImageView {

    public Phone() {
        super(new Image("file:images/phone.png"));
        setFitWidth(216);
        setFitHeight(288);
        setX(10);
        setY(Main.HEIGHT - 298);
    }
    public ImageView Arrow(){
        ImageView arrow = new ImageView(new Image("file:images/redArrow.png"));
        arrow.setFitWidth(30);
        arrow.setFitHeight(30);
        arrow.setX(84);
        arrow.setY(583);
        return arrow;
    }
}
