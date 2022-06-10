package pt.ipbeja.po2.chartracer.gui;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pt.ipbeja.po2.chartracer.model.CharTracer;

import java.io.File;
import java.io.FileNotFoundException;

public class CharTracerGUI extends Application {

    private Stage stage;                // Cria uma variavel do tipo Stage onde se vai mostrar as caixas e os botoes
    public CharTracer charTracer;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        this.stage = primaryStage;          // Cria o cenário
        this.stage.setTitle("CharTracer");   // Define um titulo para o cenário

       /* FileChooser fileChooser = new FileChooser();            // Pede o ficheiro de texto com as listas
        fileChooser.setTitle("Select the data file");    // Dá um titulo à janela a abrir para escolha do ficheiro
        fileChooser.setInitialDirectory(new File("D:\\ESTIG\\POO\\GP7"));   // Define o diretório inicial para escolha de ficheiros
        File file = fileChooser.showOpenDialog(primaryStage);   // Apos escolher o ficheiro mostra o cenario compelto

        if(file == null)
        {
            new Alert(Alert.AlertType.ERROR, "No file selected. Exiting.").showAndWait();   // Caso não seja selecionado um ficheiro mostra uma mensagem de erro
            System.exit(0); // Sai do programa
        }*/

        this.charTracer = new CharTracer();
    }

}
