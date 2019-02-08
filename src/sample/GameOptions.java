package sample;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Window which asks about number of players, size of the board and if computer will be a solver.
 */
public class GameOptions {
    private int choice = 6;
    private ComboBox numberOfPlayers;
    private ComboBox numberOfRowsComboBox;
    private String[] playerOptions;

    /**
     * Creates instance of the GameOptions(); And shows the window with questions.
     */
    public GameOptions() {
        Scene scene = new Scene(new Group(), 500, 100);
        int[] rowOptions = new int[]{3, 4, 5, 6, 7, 8, 9, 10};
        playerOptions = new String[]{"One Player", "Two Players","Computer"};
        List<Integer> choices = new ArrayList<>();
        for (int i : rowOptions) {
            choices.add(i);
        }

        numberOfRowsComboBox = new ComboBox();
        numberOfRowsComboBox.getItems().addAll(choices);
        numberOfPlayers = new ComboBox();
        numberOfPlayers.getItems().addAll(playerOptions);

        Button confirmationButton = new Button("OK");
        numberOfPlayers.setValue(playerOptions[0]);
        numberOfRowsComboBox.setValue(rowOptions[0]);


        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));


        grid.add(new Label("Number of rows: "), 0, 1);
        grid.add(numberOfRowsComboBox, 1, 1);
        grid.add(new Label("Number of players: "), 2, 1);
        grid.add(numberOfPlayers, 3, 1);
        grid.add(new Label("Game options: "), 0, 0);
        grid.add(confirmationButton, 0, 2);


        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        Stage stage = new Stage();

        confirmationButton.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });

        stage.setScene(scene);
        stage.showAndWait();


    }

    /**
     * Returns number of rows choosen by a player
     * @return choosen number of rows
     */
    public int getNumberOfRows() {
        choice = (int) numberOfRowsComboBox.valueProperty().get();
        return choice;
    }

    /**
     * Returns info if single player game or two players game was choosen.
     * @return info if single player game or two players game was choosen.
     */
    public boolean twoPlayersGame() {
        if (numberOfPlayers.valueProperty().get().equals(playerOptions[0])) {
            return false;
        } else
            return true;
    }

    /**
     * Retruns info if computer was choosen to be a codebreaker.
     * @return info if computer was choosen to be a codebreaker.
     */
    public boolean computerSolverGame() {
        if (numberOfPlayers.valueProperty().get().equals(playerOptions[2])) {
             return true;
        } else
            return false;
    }

}