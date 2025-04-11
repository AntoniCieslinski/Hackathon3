import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Plot {


    //metody do animowania tekstu
    public static void animateTextUsingTimeline(String[] contentArray, Text textDymek, double timeBetweenStrings, double durationBetweenStrings) {
        Timeline timeline = new Timeline();
        for (int i = 0; i < contentArray.length; i++) {
            String content = contentArray[i];
            KeyFrame keyFrame = new KeyFrame(
                    Duration.seconds(i * timeBetweenStrings),  // seconds between each string
                    e -> animateText(content, textDymek, durationBetweenStrings)
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.setCycleCount(1);
        timeline.play();
    }

    private static void animateText(String content, Text textDymek, double durationBetweenStrings) {
        final Animation typingAnimation = new Transition() {
            {
                setCycleDuration(Duration.seconds(durationBetweenStrings));
            }
            protected void interpolate(double frac) {
                final int length = content.length();
                final int n = Math.round(length * (float) frac);
                textDymek.setText(content.substring(0, n));
            }
        };
        typingAnimation.play();
    }
}
