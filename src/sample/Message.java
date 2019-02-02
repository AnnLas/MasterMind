package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;


public class Message {
   private String message;
   private boolean newGame;

    public Message(String message) {
        this.message = message;
    }

    public void messageShow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Master Mind Game");
        alert.setHeaderText(message);
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("New game");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            newGame =true;
            return;
        } else {
        }

    }

    public boolean isNewGame() {
        return newGame;
    }
}
