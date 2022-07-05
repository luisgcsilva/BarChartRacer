package pt.ipbeja.po2.chartracer.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class ChartBar extends Rectangle {
    private final int height = 50;

    public ChartBar(double width, Color barColor){
        this.setHeight(this.height);
        this.setFill(barColor);
        this.setWidth(width);
    }

    public void updateWidth(double width){
        this.setWidth(width);
        this.resize(width, this.height);
    }
}
