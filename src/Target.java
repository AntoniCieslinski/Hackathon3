import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Target extends Rectangle {

    int offset = 25;

    public Target() {
        super();
        setWidth(140+2*offset);
        setHeight(140+2*offset);
         setFill(Color.RED);

        //setOpacity(0);
    }

    public void setTargetToRandom(List<CyberDomek> cyberdomekList){
//        int houseNumber =(int) (Math.random()*3);
//
//        ImageView targetDomek = cyberdomekList.get(houseNumber);
//
//        this.setX(targetDomek.getX() - offset);
//        this.setY(targetDomek.getY() - offset);

        if (cyberdomekList.isEmpty()) return;

        int houseNumber = (int) (Math.random() * cyberdomekList.size());
        CyberDomek targetDomek = cyberdomekList.get(houseNumber);

        this.setX(targetDomek.getX() - offset);
        this.setY(targetDomek.getY() - offset);

    }

    public double getCenterX(){
        return (getX()+getWidth()/2);
    }

    public double getCenterY(){
        return (getY() + getWidth()/2);
    }
}
