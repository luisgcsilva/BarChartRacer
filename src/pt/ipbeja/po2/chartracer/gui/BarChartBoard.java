package pt.ipbeja.po2.chartracer.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pt.ipbeja.po2.chartracer.model.ChartRacer;
import pt.ipbeja.po2.chartracer.model.Data;
import pt.ipbeja.po2.chartracer.model.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class BarChartBoard extends Pane implements View {
    private static final Color[] COLORS = {Color.BLUEVIOLET, Color.BLUE, Color.ANTIQUEWHITE, Color.BLUEVIOLET,
            Color.DARKGREY, Color.LIGHTSKYBLUE, Color.LIGHTBLUE, Color.LIGHTSTEELBLUE,
            Color.CADETBLUE, Color.DEEPSKYBLUE, Color.SKYBLUE, Color.SLATEBLUE};
    private ArrayList<Data> data;
    private final int NUMBER_OF_BARS = 12;
    private ChartRacer chartRacer;
    private VBox vBox = new VBox();
    private int xBorder = 20;
    private int xScale = 1200;
    private final int yScale = 700;
    private ArrayList<ChartBar> chartBar = new ArrayList<>();
    private ArrayList<Data> dataFromPeriod = new ArrayList<>();
    private ArrayList<Text> labels = new ArrayList<>();
    private ArrayList<Text> numbers = new ArrayList<>();
    private Text period = new Text();
    File file;
    public BarChartBoard(File file) {
        this.chartRacer = new ChartRacer(this, file);
        this.data = this.chartRacer.getDataArrayList();
        this.drawBoard();
        this.chartRacer.executeNewThread();
    }

    public void drawBoard(){
        this.vBox.setLayoutY(xBorder);
        this.vBox.setLayoutX(xBorder);
        this.drawAxe();
        this.drawInitialBars();
    }

    private void drawAxe(){
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

    private void drawInitialBars(){
        for (int i = 0; i < NUMBER_OF_BARS; i++){
            double width =  data.get(i).population * (0.95 * xScale) / data.get(0).population;
            StackPane stackPane = new StackPane();
            HBox hBox = new HBox();
            labels.add(new Text(data.get(i).city));
            numbers.add(new Text(String.valueOf(data.get(i).population)));
            stackPane.setAlignment(labels.get(i), Pos.CENTER_RIGHT);
            chartBar.add(new ChartBar(width, COLORS[i]));
            stackPane.setAlignment(Pos.BASELINE_LEFT);
            stackPane.getChildren().addAll(chartBar.get(i), labels.get(i));
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.getChildren().addAll(stackPane, numbers.get(i));
            this.vBox.getChildren().add(hBox);
        }
        this.getChildren().add(vBox);
        this.drawLabel(this.data.get(0).year);
    }

   /* private void animateBars(){
        int counter = 1;
        ChartBar rectangle = new ChartBar(data.get(1).population * (0.95 * xScale) / data.get(0).population, Color.RED);

        for (int i = 1; i < 50; i++) {
            double width = data.get(counter).population * (0.95 * xScale) / data.get(0).population;
            Timeline animation = new Timeline(
                    new KeyFrame(Duration.millis(100), new KeyValue(rectangle.widthProperty(), width))
            );
            animation.play();
            counter+=12;
        }
        this.vBox.getChildren().add(rectangle);
        this.pane.getChildren().add(vBox);
    }*/

    private void drawLabel(String period){
        this.period.setText(period);
        this.period.setFont(new Font(50));
        HBox hBox = new HBox();
        hBox.getChildren().add(this.period);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        this.vBox.getChildren().add(hBox);
    }

    public void updateBoard(String period){
        this.dataFromPeriod = this.chartRacer.getDatabyDate(period);
        for (int i = 0; i < this.dataFromPeriod.size(); i++){
            double width = this.dataFromPeriod.get(i).population * (0.95 * xScale) / this.dataFromPeriod.get(0).population;
            Timeline animation = new Timeline(
                    new KeyFrame(Duration.millis(100), new KeyValue(this.chartBar.get(i).widthProperty(), width))
            );
            this.chartBar.get(i).updateWidth(width);
            this.numbers.get(i).setText(String.valueOf(this.dataFromPeriod.get(i).population));
            this.labels.get(i).setText(this.dataFromPeriod.get(i).city);
            this.period.setText(period);
            animation.play();
        }
    }
}
