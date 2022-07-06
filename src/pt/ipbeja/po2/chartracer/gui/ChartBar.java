package pt.ipbeja.po2.chartracer.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class ChartBar extends Rectangle {
    private final int height = 50;

    /**
     * Cronstructor of the object ChartBar
     * @param width The desired width for the ChartBar
     * @param barColor The desired color for the ChartBar
     */
    public ChartBar(double width, Color barColor){
        this.setHeight(this.height);
        this.setFill(barColor);
        this.setWidth(width);
    }

    /**
     * Updates the width of the bars
     * @param width
     */
    public void updateWidth(double width){
        this.setWidth(width);
        this.resize(width, this.height);
    }
}
