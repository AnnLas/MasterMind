package sample;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Hint extends GridPane {
    private int numberOfDigits = 4;


    public Hint() {
        setAlignment(Pos.CENTER);
        for (int i = 0; i < numberOfDigits / 2; i++) {
            for (int j = 0; j < numberOfDigits / 2; j++) {
                add(new ImageView("images/smaller_hole.png"), i, j);

            }
        }
    }

    public void setHint(int sameDigits, int samePositionAndDigits) {
        System.out.println(samePositionAndDigits);
        System.out.println(sameDigits);
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < numberOfDigits / 2; i++) {
            for (int j = 0; j < numberOfDigits / 2; j++) {
                if (counter1 < samePositionAndDigits) {
                    add(new ImageView("images/little_redball.png"), i, j);
                    counter1++;
                } else if (counter2 < sameDigits) {
                    add(new ImageView("images/little_greyball.png"), i, j);
                    counter2++;
                }

            }
        }


    }

    public void setClear() {

        setAlignment(Pos.CENTER);
        getChildren().clear();
        for (int i = 0; i < numberOfDigits / 2; i++) {
            for (int j = 0; j < numberOfDigits / 2; j++) {
                add(new ImageView("images/smaller_hole.png"), i, j);

            }
        }
    }
}
