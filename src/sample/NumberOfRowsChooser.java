package sample;


import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NumberOfRowsChooser  {
    private int choice = 6;

    public NumberOfRowsChooser() {
        int [] options = new int[]{3,4,5,6,7,8,9,10};
        List<Integer> choices = new ArrayList<>();
        List<Integer> choices2 = new ArrayList<>();
        for (int i:options) {
            choices.add(i);
        }
        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(choice, choices);
        Button button = new Button();
        button.setText("meloniki");
        dialog.getDialogPane().getChildren().add(button);
        dialog.setTitle("Master Mind Game");
        dialog.setHeaderText("Select difficulty level.");
        dialog.setContentText("Choose number of rows:");


        Optional<Integer> result = dialog.showAndWait();
        if (result.isPresent()){
           choice = result.get();
        }

        result.ifPresent(number -> choice =number);

    }

    public int getChoice() {
        return choice;
    }
}