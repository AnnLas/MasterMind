package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point of the app. Starts the game and asks about game option (such as number of rows,
 * number of players, and if computer breaks the code).
 */
public class Controller extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameOptions gameOptions = new GameOptions();

        Board board = new Board(gameOptions.getNumberOfRows()+1, 4, gameOptions.twoPlayersGame(), gameOptions.computerSolverGame());
        if (gameOptions.twoPlayersGame()) {
            board.setActiveRow(0);
        }
        else {
            board.setActiveRow(gameOptions.getNumberOfRows());
        }
        Scene scene = new Scene(board, 450, gameOptions.getNumberOfRows()*1.2*65);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }
}
