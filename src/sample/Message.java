package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Represents window with given message for player.
 */
public class Message {
   private String message;
   private boolean newGame;

    /**
     * Creates instance of the message window with the given text.
     * @param message message for player
     */
    public Message(String message) {
        this.message = message;
    }

    /**
     * Shows message with confirmation button and new game button
     */
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

    /**
     * Returns info if player wants to play again
     * @return info if player wants to play again
     */
    public boolean isNewGame() {
        return newGame;
    }
}
