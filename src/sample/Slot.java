package sample;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class Slot extends StackPane {
    private static int currentColor;
    private boolean active;


    public Slot() {
        ImageView image = new ImageView("images/hole.png");
        setAlignment(Pos.CENTER);
        getChildren().add(image);
        setOnMouseClicked(mouseEvent -> {
            if (active) {
                image.setImage(new Image("images/ball" + currentColor + ".png"));

            }
        });


    }

    public static void setCurrentColor(int currentColor) {
        Slot.currentColor = currentColor;
    }

    public static int getCurrentColor() {
        return currentColor;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
