package sample;

import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;



public class Board extends Pane {
    private int numberOfRows;
    private int numberOfColumns;
    private int activeRow = 0;
    private Slot[][] slots;
    private Hint[] hints;

    public Board(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        slots = new Slot[numberOfColumns][numberOfRows];
        hints = new Hint[numberOfRows];
        setPrefSize(600, 600);
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Slot slot = new Slot();
                slot.setTranslateX(j * 60);
                slot.setTranslateY(i * 60);

                getChildren().add(slot);
                if (j == numberOfColumns - 1) {
                    Hint hint = new Hint();
                    hint.setTranslateX(j * 60 * 1.4);
                    hint.setTranslateY(i * 60);
                    getChildren().add(hint);
                    hints[i] = hint;
                }
                slots[j][i] = slot;

            }
        }
        BallPicker ballPicker = new BallPicker();
        ballPicker.setTranslateX((numberOfColumns + 1) * 60);
        ballPicker.setTranslateY((numberOfRows - 2.5) * 60);
        getChildren().add(ballPicker);
        Button startGameButton = new Button();
        startGameButton.setText("Start");
        startGameButton.setOnMouseClicked(mouseEvent -> nextRow());
        startGameButton.setTranslateX((numberOfColumns + 1)*60);
        startGameButton.setTranslateY(0);
        getChildren().add(startGameButton);

        ballPicker.setOnMouseClicked(mouseEvent -> setCursor(new ImageCursor(new Image("images/ball" + Slot.getCurrentColor() + ".png"))));
    }

    private void nextRow(){
        activeRow++;
        setActiveRow(activeRow);
    }

    public void setActiveRow(int activeRow) {
        this.activeRow = activeRow;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                slots[j][i].setActive(false);

            }
            for (int j = 0; j < numberOfColumns; j++) {
                slots[j][activeRow].setActive(true);
            }
        }
    }
}
