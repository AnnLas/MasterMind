package sample;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;




public class Slot extends StackPane {
    private static int currentColor;
    private boolean active;
    private int digit;

    public Slot() {
        ImageView image = new ImageView("images/hole.png");
        setAlignment(Pos.CENTER);
        getChildren().add(image);
        setOnMouseClicked(mouseEvent -> {
            if (active) {
                getChildren().clear();
                image.setImage(new Image("images/ball" + currentColor + ".png"));
                getChildren().add(image);
                digit=currentColor;
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
      ImageView frameImage = new ImageView("images/active_frame.png");

        if (active){
            setAlignment(Pos.CENTER);
            getChildren().add(frameImage);
        }
          this.active = active;
    }

    public void unHide(){
        ImageView image = new ImageView("images/ball" + digit + ".png");
        setAlignment(Pos.CENTER);
        getChildren().clear();
        getChildren().add(image);

    }
    public void setHidden(){
        ImageView image = new ImageView("images/question_mark.png");
        setAlignment(Pos.CENTER);
        getChildren().clear();
        getChildren().add(image);
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }
}
