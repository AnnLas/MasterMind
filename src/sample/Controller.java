package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller extends Application {
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board(8, 4);
        board.setActiveRow(0);
        scene = new Scene(board, 800, 800);
        stage.setScene(scene);
        stage.show();


    }
}
