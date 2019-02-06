package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameOptions gameOptions = new GameOptions();

        Board board = new Board(gameOptions.getNumberOfColumns()+1, 4, gameOptions.twoPlayersGame(), gameOptions.computerSolverGame());
        if (gameOptions.twoPlayersGame()) {
            board.setActiveRow(0);
        }
        else {
            board.setActiveRow(gameOptions.getNumberOfColumns());
        }
        Scene scene = new Scene(board, 450, gameOptions.getNumberOfColumns()*1.2*65);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }
}
