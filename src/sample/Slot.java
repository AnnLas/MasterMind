package sample;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


/**
 * Represents single slot on the board
 */
public class Slot extends StackPane {
    private static int currentColor;
    private boolean active;
    private int digit;

    /**
     * Creates instance of the slot which handles click events. If slot is active and target
     * colour is selected, slot change image.
     */
    public Slot() {
        ImageView image = new ImageView("images/hole.png");
        setAlignment(Pos.CENTER);
        getChildren().add(image);
        setOnMouseClicked(mouseEvent -> {
            if (active&&!(currentColor==0)) {
                getChildren().clear();
                image.setImage(new Image("images/ball" + currentColor + ".png"));
                getChildren().add(image);
                digit=currentColor;
            }
        });


    }

    /**
     * Sets color which was choosen by a player
     * @param currentColor choosen color
     */
    public static void setCurrentColor(int currentColor) {
        Slot.currentColor = currentColor;
    }
    /**
     * Gets color which was choosen by a player
     */
    public static int getCurrentColor() {
        return currentColor;
    }

    /**
     * Sets target slot active which means thah player can puts peg in.
     * @param active
     */
    public void setActive(boolean active) {
      ImageView frameImage = new ImageView("images/active_frame.png");

        if (active){
            setAlignment(Pos.CENTER);
            getChildren().add(frameImage);
        }
          this.active = active;
    }

    /**
     * Unhide the peg on a slot
     */
    public void unHide(){
        ImageView image = new ImageView("images/ball" + digit + ".png");
        setAlignment(Pos.CENTER);
        getChildren().clear();
        getChildren().add(image);

    }

    /**
     * Hide the peg on a slot
     */
    public void setHidden(){
        ImageView image = new ImageView("images/question_mark.png");
        setAlignment(Pos.CENTER);
        getChildren().clear();
        getChildren().add(image);
    }

    /**
     * Returns digit which was coded by putting peg in the slot
     * @return digit, part of the code
     */
    public int getDigit() {
        return digit;
    }
    /**
     * Set digit which is coded by putting peg in the slot
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }
}
