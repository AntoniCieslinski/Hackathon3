import javafx.scene.image.ImageView;

public class Sheep {
    int x;
    int y;
    int mapPart;
    ImageView image;
    boolean zawirusowana = false;
    //default nie ma wirusa

    public Sheep(int x, int y, int mapPart) {
        this.x = x;
        this.y = y;
        this.mapPart = mapPart;
        if (zawirusowana){
            //change image if zawirusowana
        }

    }



    public static void detectPlayer(){

    }
}
