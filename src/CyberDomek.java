import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CyberDomek extends ImageView {




    public CyberDomek() {
        super();
        Image image = new Image ("file:images/cyberDomek.png");
        this.setImage(image);
        this.setFitWidth(150);
        this.setFitHeight(150);
    }

//    public static void generateLocation(List<CyberDomek>){
//
//
//
//    }

    public List<CyberDomek> generateTheFourDomki (){
        List<CyberDomek> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            boolean correctCoordinates = false;
            CyberDomek cyberDomek = new CyberDomek();
            while (!correctCoordinates){
                double newX = Math.random()*1200;
                double newY = Math.random()*800;
                for (int j = 0; j < list.size(); j++) {
                    double upperXBound = list.get(j).getX() + getFitWidth();
                    double lowerXBound = list.get(j).getX();

                    double upperYBound = list.get(j).getY() + getFitHeight();
                    double lowerYBound = list.get(j).getY();

                    if ((newX<lowerXBound && newX>upperXBound)||(newY<lowerYBound && newY>upperYBound)){
                        correctCoordinates = true;
                    }
                }

            }

            list.add(cyberDomek);

        }

        return list;
    }


}
