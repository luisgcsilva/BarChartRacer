package pt.ipbeja.po2.chartracer.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pt.ipbeja.po2.chartracer.model.ChartRacer;
import pt.ipbeja.po2.chartracer.model.Data;
import pt.ipbeja.po2.chartracer.model.View;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class BarChartBoard extends Pane implements View {
    private final int NUMBER_OF_BARS = 12;
    private ChartRacer chartRacer;
    private VBox vBox = new VBox();
    private int xBorder = 50;
    private int xScale = 1200;
    private final int yScale = 700;
    private ArrayList<ChartBar> chartBar = new ArrayList<>();
    private ArrayList<Data> dataFromPeriod = new ArrayList<>();
    private ArrayList<Text> labels = new ArrayList<>();
    private ArrayList<Text> numbers = new ArrayList<>();
    private Text period = new Text();
    private String graphTitle;
    private DataMenu dataMenu;

    /**
     * Constructor of the Board
     * @param file The file to be read
     */
    public BarChartBoard(File file) {
        this.chartRacer = new ChartRacer(this, file);
        this.graphTitle = chartRacer.graphTitle;
        this.dataMenu = new DataMenu(this.chartRacer);
        this.drawBoard();
        this.chartRacer.executeNewThread();
    }

    /**
     *  Draws the entire board
     */
    public void drawBoard(){
        this.getChildren().add(dataMenu);
        this.vBox.setLayoutY(xBorder);
        this.vBox.setLayoutX(xBorder);
        this.drawAxes();
        this.drawInitialBars();
    }

    /**
     * Draws the Axes lines
     */
    private void drawAxes(){

        Line xLine = new Line();
        xLine.setStartX(xBorder);
        xLine.setEndX(xScale + xBorder);
        Line yLine = new Line();
        yLine.setStartX(xBorder);
        yLine.setEndX(xBorder);
        yLine.setStartY(xBorder);
        yLine.setEndY(yScale);
        this.vBox.getChildren().add(xLine);
        this.getChildren().add(yLine);
    }

    /**
     * Draws the Initial Bars on the Graphic
     */
    private void drawInitialBars(){
        for (int i = 0; i < NUMBER_OF_BARS; i++){
            double width =  this.chartRacer.getDataArrayList().get(i).value * (0.95 * xScale) / this.chartRacer.getDataArrayList().get(0).value;
            StackPane stackPane = new StackPane();
            HBox hBox = new HBox();
            this.labels.add(new Text(this.chartRacer.getDataArrayList().get(i).city));
            this.numbers.add(new Text(String.valueOf(this.chartRacer.getDataArrayList().get(i).value)));
            stackPane.setAlignment(this.labels.get(i), Pos.CENTER_RIGHT);
            this.chartBar.add(new ChartBar(width, this.chartRacer.getDataArrayList().get(i).getColor()));
            stackPane.setAlignment(Pos.BASELINE_LEFT);
            stackPane.getChildren().addAll(this.chartBar.get(i), this.labels.get(i));
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.getChildren().addAll(stackPane, this.numbers.get(i));
            this.vBox.getChildren().add(hBox);
        }
        this.getChildren().add(vBox);
        this.drawLabel(this.chartRacer.getDataArrayList().get(0).date);
    }

    /**
     * Draws the label at the end of the graphic with the period of the current data
     * @param period The period of the current data
     */
    private void drawLabel(String period){
        this.period.setText(period);
        this.period.setFont(new Font(50));
        HBox hBox = new HBox();
        hBox.getChildren().add(this.period);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        this.vBox.getChildren().add(hBox);
    }

    /**
     * Updates the bars on the graphic based on the next period
     * @param period The next period from the dataset to be drawn
     */
    public void updateBoard(String period){
        this.dataFromPeriod = this.chartRacer.getDataByDate(period);
        for (int i = 0; i < NUMBER_OF_BARS; i++){
            double width = this.dataFromPeriod.get(i).value * (0.95 * xScale) / this.dataFromPeriod.get(0).value;
            Timeline animation = new Timeline(
                    new KeyFrame(Duration.millis(50), new KeyValue(this.chartBar.get(i).widthProperty(), width))
            );
            this.chartBar.get(i).updateWidth(width);
            this.chartBar.get(i).setFill(dataFromPeriod.get(i).getColor());
            this.numbers.get(i).setText(String.valueOf(this.dataFromPeriod.get(i).value));
            this.labels.get(i).setText(this.dataFromPeriod.get(i).city);
            this.period.setText(period);
            animation.play();
        }
    }
}
