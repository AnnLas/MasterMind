package sample;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Hint extends GridPane {

    ImageView hint1 = new ImageView("images/smaller_hole.png");
    ImageView hint2 = new ImageView("images/smaller_hole.png");
    ImageView hint3 = new ImageView("images/smaller_hole.png");
    ImageView hint4 = new ImageView("images/smaller_hole.png");

    public Hint() {

        setAlignment(Pos.CENTER);
        add(hint1, 0, 0);
        add(hint2, 1, 0);
        add(hint3, 0, 1);
        add(hint4, 1, 1);
    }
}
