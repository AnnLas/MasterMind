package sample;


import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class Board extends Pane {
    private int numberOfRows;
    private int numberOfColumns;
    private int activeRow = 0;
    private Slot[][] slots;
    private Hint[] hints;
    private Game game;
    private ArrayList<Integer> providedCode;
    private Button startGameButton;

    public Board(int numberOfRows, int numberOfColumns) {
        game = new Game();
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
                if (j == numberOfColumns - 1 && i != 0) {
                    Hint hint = new Hint(numberOfColumns);
                    hint.setTranslateX(j * 60 * 1.4);
                    hint.setTranslateY(i * 60);
                    getChildren().add(hint);
                    hints[i] = hint;
                }
                slots[j][i] = slot;

            }
        }

        addComponents();


    }

    private void addComponents() {
        BallPicker ballPicker = new BallPicker();
        ballPicker.setTranslateX((numberOfColumns + 1) * 60);
        ballPicker.setTranslateY((numberOfRows - 2.5) * 60);
        getChildren().add(ballPicker);
        ballPicker.setOnMouseClicked(mouseEvent -> setCursor(new ImageCursor(new Image("images/ball" + Slot.getCurrentColor() + ".png"))));


        startGameButton = new Button();
        Button checkButton = new Button();

        startGameButton.setText("Start");
        checkButton.setText("Check");

        startGameButton.setOnMouseClicked(mouseEvent ->
        {
            if (!game.isSecondPlayerTurn()) {
                if (checkCorectness()) {
                    game.setSecondPlayerTurn(true);
                    activeRow = (numberOfRows - 1);
                    setActiveRow(activeRow);
                    startGameButton.setText("New game");
                    for (int i = 0; i < numberOfColumns; i++) {
                        slots[i][0].setHidden();
                    }

                }
            } else {
                Message message = new Message("Do you wanna try again?");
                message.messageShow();
                if (message.isNewGame()) {
                  prepareBoard();
                }

            }


        });

        checkButton.setOnMouseClicked(mouseEvent -> {
            String comunicat = "";
            if (game.isSecondPlayerTurn() && checkCorectness() && game.isRunning()) {
                if (!(activeRow == 1) && !game.isWinner()) {
                    nextRow();
                } else {
                    checkCorectness();
                    for (int i = 0; i < numberOfColumns; i++) {
                        slots[i][0].unHide();
                        if (game.isWinner()) {
                            comunicat = "Congratulations, you won!";
                            ;
                        } else {
                            comunicat = "You lose, do you wanna try again?";

                        }
                    }
                    game.setRunning(false);
                    Message message = new Message(comunicat);
                    message.messageShow();
                    if (message.isNewGame()) {
                        prepareBoard();

                    }

                }

            }

        });
        startGameButton.setTranslateX((numberOfColumns + 2) * 55);
        startGameButton.setTranslateY(0);

        checkButton.setTranslateX((numberOfColumns + 2) * 55);
        checkButton.setTranslateY(60);

        getChildren().addAll(startGameButton, checkButton);


    }

    private boolean checkCorectness() {
        providedCode = new ArrayList<>();
        for (int i = 0; i < numberOfColumns; i++) {
            if (slots[i][activeRow].getDigit() == 0) {
                System.out.println("not enought numbers");
                return false;
            }
            if (!game.isSecondPlayerTurn() && providedCode.contains(slots[i][activeRow].getDigit())) {
                System.out.println("ball cannot repeat in the sequence");
                return false;
            } else {
                providedCode.add(slots[i][activeRow].getDigit());
            }
        }
        if (activeRow == 0) {
            game.setCode(providedCode);
        } else {
            hints[activeRow].setHint(game.checkMatch(providedCode)[0], game.checkMatch(providedCode)[1]);
        }
        return true;
    }


    private void nextRow() {
        if (activeRow == numberOfRows) {
            game.setRunning(false);
            return;
        }
        activeRow--;
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

    public void prepareBoard() {
        game = new Game();
        activeRow = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                slots[j][i].getChildren().clear();
                slots[j][i].getChildren().add(new Slot());
                slots[j][i].setDigit(0);

                if (j == numberOfColumns - 1 && i != 0) {
                    hints[i].setClear();
                }


            }

        }
        startGameButton.setText("Start");
        setActiveRow(activeRow);


    }
}
