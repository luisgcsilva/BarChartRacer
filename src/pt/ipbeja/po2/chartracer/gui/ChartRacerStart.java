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

    private Stage stage;                // Cria uma variavel do tipo Stage onde se vai mostrar as caixas e os botoes
    private BarChartBoard barChartBoard;
    private File file;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        this.stage = primaryStage;          // Cria o cenário
        this.stage.setTitle("BarChartRacer");   // Define um titulo para o cenário

        FileChooser fileChooser = new FileChooser();            // Pede o ficheiro de texto com as listas
        fileChooser.setTitle("Select the data file");    // Dá um titulo à janela a abrir para escolha do ficheiro
        fileChooser.setInitialDirectory(new File("./files/datafiles"));   // Define o diretório inicial para escolha de ficheiros
        this.file = fileChooser.showOpenDialog(primaryStage);   // Apos escolher o ficheiro mostra o cenario compelto

        if(this.file == null)
        {
            new Alert(Alert.AlertType.ERROR, "No file selected. Exiting.").showAndWait();   // Caso não seja selecionado um ficheiro mostra uma mensagem de erro
            System.exit(0); // Sai do programa
        }

        this.barChartBoard = new BarChartBoard(file);

        Scene sc = new Scene(barChartBoard, 1500, 950);

        this.stage.setScene(sc);
        this.stage.show();
    }
}
