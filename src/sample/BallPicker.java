package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class BallPicker extends GridPane {

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
