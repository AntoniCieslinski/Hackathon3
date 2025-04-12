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
//        Sheep sheep = new Sheep();
    }

    public static void generateLocation(List<CyberDomek> domki){
    }

    /*public static List<CyberDomek> generateTheFourDomki (){
        List<CyberDomek> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            boolean correctCoordinates = false;
            CyberDomek cyberDomek = new CyberDomek();
            while (!correctCoordinates){
                double newX = Math.random()*1200;
                double newY = Math.random()*800;
                for (int j = 0; j < list.size(); j++) {
                    double upperXBound = list.get(j).getX() + cyberDomek.getFitWidth();
                    double lowerXBound = list.get(j).getX();

                    double upperYBound = list.get(j).getY() + cyberDomek.getFitHeight();
                    double lowerYBound = list.get(j).getY();

                    if (!(newX<lowerXBound && newX>upperXBound)||(newY<lowerYBound && newY>upperYBound)){
                        correctCoordinates = true;
                    }
                }
            }
            list.add(cyberDomek);
            Main.cyberdomekList = list;
            for (int j = 0; j <= list.size(); j++) {
                Main.ap1.getChildren().add(list.get(j));
            }
        }
        return list;
    }*/

    public static List<CyberDomek> generateTheFourDomki() {
        List<CyberDomek> list = new ArrayList<>();
        int maxAttempts = 1000;

        for (int i = 0; i < 4; i++) {
            CyberDomek cyberDomek = new CyberDomek();
            boolean positionFound = false;
            int attempts = 0;

            while (!positionFound && attempts < maxAttempts) {
                double newX = Math.random() * (Main.WIDTH - cyberDomek.getFitWidth());
                double newY = Math.random() * (Main.HEIGHT - cyberDomek.getFitHeight());
                cyberDomek.setX(newX);
                cyberDomek.setY(newY);

                boolean overlaps = false;
                for (CyberDomek existing : list) {
                    if (cyberDomek.getBoundsInParent().intersects(existing.getBoundsInParent())) {
                        overlaps = true;
                        break;
                    }
                }

                if (!overlaps) {
                    positionFound = true;
                } else {
                    attempts++;
                }
            }

            if (positionFound) {
                list.add(cyberDomek);
//                Main.ap1.getChildren().add(cyberDomek);
            } else {
                System.out.println("Failed to place CyberDomek without overlap after " + maxAttempts + " attempts.");
            }
        }

        Main.cyberdomekList = list;
        return list;
    }

}
