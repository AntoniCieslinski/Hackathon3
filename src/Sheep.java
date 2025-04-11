import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;

import java.util.Vector;

public class Sheep extends ImageView{
    int x;
    int y;
    int mapPart;
    ImageView image;
    int steps;

    Direction direction = Direction.RIGHT;
    boolean zawirusowana = false;
    enum Direction {
        RIGHT(0, 1, 0),
        DOWN(1, 1, 0),
        LEFT(2, 1, 0),
        UP(3, 1, 0);
        int index;
        final int x;
        final int y;


        Direction(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
        public static Direction changeDirection(Direction currDirection){
            return values()[(currDirection.index + 1) % 4];
        }
    }

    //default nie ma wirusa

    public Sheep(int x, int y, int mapPart) {
        this.x = x;
        this.y = y;
        this.mapPart = mapPart;
        if (zawirusowana){
            //change image if zawirusowana
        }

    }

//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    public static void detectPlayer(){
        //if player
    }

    public void randomWalk() {
        if (steps >= 150) {
            direction.index += 1;
            if (direction.index >= 4){
                direction.index = 0;
            }
        }
        setX(getX() + direction.x);
        setY(getY() + direction.y);
        steps++;
    }
}
