package sample;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Fragment of the UI which represents hint after comparison of two codes
 * (given by a codebreaker, and code to be break)
 * Red balls represents perfect match, grey only color match.
 */
public class Hint extends GridPane {
    private int numberOfDigits = 4;

    /**
     * Creates instance of the Hint
     * @param digitsNumber number of the slots in hint.
     */
    public Hint(int digitsNumber) {
        this.numberOfDigits = digitsNumber;
        setAlignment(Pos.CENTER);
        for (int i = 0; i < numberOfDigits / 2; i++) {
            for (int j = 0; j < numberOfDigits /2; j++) {
                add(new ImageView("images/smaller_hole.png"), i, j);

            }
        }
    }

    /**
     * Sets hint after comparison
     * @param sameDigits number of perfect matched digits
     * @param samePositionAndDigits number of only color matched digits
     */
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

    /**
     * Clears the hint from the pegs.
     */
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
