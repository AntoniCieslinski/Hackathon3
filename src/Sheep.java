import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.util.Vector;

public class Sheep extends ImageView{
    static Image image = new Image("file:images/sheep-right.png");
    int steps;

    Direction direction = Direction.RIGHT;
    boolean zawirusowana = true;
    enum Direction {
        RIGHT(0, 1, 0),
        DOWN(1, 0, 1),
        LEFT(2, -1, 0),
        UP(3, 0, -1);
        int index;
        final int x;
        final int y;



        Direction(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;

            //this.x = (int) (x - 130);
            //this.y = (int) (y - 130);
        }
        public static Direction changeDirection(Direction currDirection){
            return values()[(currDirection.index + 1) % 4];
        }


    }
//    Polygon triangle = new Polygon();

    //default nie ma wirusa

    public Sheep(int x, int y) {
        super();
        setImage(image);
        setX(x- image.getWidth()+30);
        setY(y- image.getHeight());

        int random = (int) (Math.random()*800);
        for (int i = 0; i < random; i++) {
            randomWalk();
        }

        if (zawirusowana){
            //change image if zawirusowana
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(12), event -> {
            randomWalk();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    public boolean detectPlayer(Player player){

        if (this.getBoundsInLocal().intersects(player.imageView.getBoundsInLocal())){
            System.out.println("Collision");
            return true;

        }

        return false;

//        if (Main.player.imageView.intersects()) {
//            return;
//        }
//        return;


    }

    public void randomWalk() {
        setX(getX() + direction.x);
        setY(getY() + direction.y);
        steps++;
        if (steps >= 230) {
            direction = Direction.changeDirection(direction);
            steps = 0;
        }
    }



}
