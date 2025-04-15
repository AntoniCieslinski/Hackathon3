import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Stack;

public class GraKorkowa {


    static Image korekon = new Image("file:images/KorekOn.png");
    static Image korekoff = new Image("file:images/KorekOff.png");

    public static void Korki(){
        Text text = new Text();
        text.setText("Przełącz wszystkie na czerwone");
        text.setFill(Color.RED);
        text.setWrappingWidth(700);
        Font font = new Font("Arial", 70);
        text.setX(200);
        text.setY(100);
        text.setFont(font);

        Stage stage = new Stage();
        Scene scene;
        AnchorPane root = new AnchorPane();

        ImageView korek1 = new ImageView(Math.random() < 0.5 ? korekon : korekoff);
        ImageView korek2 = new ImageView(Math.random() < 0.5 ? korekon : korekoff);
        ImageView korek3 = new ImageView(Math.random() < 0.5 ? korekon : korekoff);
        ImageView korek4 = new ImageView(Math.random() < 0.5 ? korekon : korekoff);

        korek1.setX(150);
        korek1.setY(Main.HEIGHT/2);
        korek2.setY(Main.HEIGHT/2);
        korek3.setY(Main.HEIGHT/2);
        korek4.setY(Main.HEIGHT/2);
        korek2.setX(350);
        korek3.setX(550);
        korek4.setX(750);

        ImageView[] imageViews = { korek1, korek2, korek3, korek4 };
        for (int i = 0; i < imageViews.length; i++) {
            int finalI = i;
            imageViews[i].setOnMouseClicked(e -> {
                Image current = imageViews[finalI].getImage();
                if (current.equals(korekon)) {
                    current = korekoff;
                }
                else {
                    current = korekon;
                }
                imageViews[finalI].setImage(current); // change image on click

                if (korek1.getImage().equals(korekon)&& korek2.getImage().equals(korekon)&& korek3.getImage().equals(korekon)&& korek4.getImage().equals(korekon)){
                    text.setText("Gratulacje!!!");
                    text.setFill(Color.GREEN);
                }
            });
        }
        root.getChildren().addAll(korek1,korek2,korek3,korek4, text);

        scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}
