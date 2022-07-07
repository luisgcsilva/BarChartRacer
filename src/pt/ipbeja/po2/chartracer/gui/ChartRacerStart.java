package pt.ipbeja.po2.chartracer.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 01/07/2022
 */

public class ChartRacerStart extends Application {

    private Stage stage;
    private BarChartBoard barChartBoard;
    private File file;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.setTitle("BarChartRacer");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select the data file");
        fileChooser.setInitialDirectory(new File("./files/datafiles"));
        this.file = fileChooser.showOpenDialog(primaryStage);

        if(this.file == null) {
            new Alert(Alert.AlertType.ERROR, "No file selected. Exiting.").showAndWait();
            System.exit(0);
        }

        this.barChartBoard = new BarChartBoard(file);

        Scene sc = new Scene(barChartBoard, 1500, 950);

        this.stage.setScene(sc);
        this.stage.show();
    }
}
