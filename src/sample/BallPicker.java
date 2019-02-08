package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Part of the user interface.
 * Grid of the color balls to choose from. Each ball represents unique digit.
 */
public class BallPicker extends GridPane {


    /**
     * Creates instance of the BallPicker. Handles click events on it and change the current color.
     * */
    public BallPicker() {

        for (int i = 1; i < 7; i++) {
            ImageView imageView = new ImageView(new Image("images/ball" + i + ".png"));
            add(imageView, i % 2, i % 3);
            int a = i;
            imageView.setOnMouseClicked(mouseEvent -> {
                Slot.setCurrentColor(a);
            });

        }


    }
}
