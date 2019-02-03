package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        NumberOfRowsChooser numberOfRowsChooser = new NumberOfRowsChooser();
        Board board = new Board(numberOfRowsChooser.getChoice()+1, 4);
        board.setActiveRow(0);
        Scene scene = new Scene(board, 400, numberOfRowsChooser.getChoice()*1.2*65);
        stage.setScene(scene);
        stage.show();


    }
}
