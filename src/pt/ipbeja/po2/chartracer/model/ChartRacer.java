package pt.ipbeja.po2.chartracer.model;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import static java.lang.Thread.sleep;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class ChartRacer{
    private View view;
    private ArrayList<Data> dataArrayList;
    private ArrayList<String> periods;

    /**
     * Constructor of the class ChartRacer
     * @param view
     * @param file
     */
    public ChartRacer(View view, File file){
        this.view = view;
        this.dataArrayList = ReadFile.readFile(file);
        this.dataArrayList = this.orderList(this.dataArrayList);
        this.periods = this.getDates();
        this.setRegionColor();
    }

    /**
     * Orders the ArrayList of Data
     * @param list The ArrayList to be ordered
     * @return list Returns the list ordered
     */
    public ArrayList<Data> orderList(ArrayList<Data> list){
        Collections.sort(list);
        return list;
    }

    /**
     * Creates a Map of colors for each region
     * @return Map<String, Color> Returns the Map with the colors for each region
     */
    public void setRegionColor(){
        Map<String, Color> colorRegions = new HashMap<>();

        for (Data data : this.dataArrayList){
            if (colorRegions.isEmpty())
            {
                colorRegions.put(data.getRegion(), getRandomColor());
            }
            else {
                int i = 0;
                while (colorRegions.size() > i) {
                    if (!colorRegions.containsKey(data.getRegion())) {
                        colorRegions.put(data.getRegion(), getRandomColor());
                    }
                    i++;
                }
            }
            for (Map.Entry map : colorRegions.entrySet()){
                String key = (String)map.getKey();
                if (data.getRegion().equals(key)){
                    data.setColor((Color)map.getValue());
                }
            }
        }
    }

    /**
     * Generates a random color to the regions
     * @return color Returns a random color
     */
    private Color getRandomColor(){
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        float w = 1;
        Color color = new Color(r, g, b, w);

        return color;
    }

    /**
     * Gets the data from a certain date
     * @param date The date to get the data
     * @return dataArrayList Returns the ArrayList with the desired data
     */
    public ArrayList<Data> getDataByDate(String date){
        ArrayList<Data> dataArrayList = new ArrayList<>();

        for (int i = 0; i < this.dataArrayList.size(); i++) {
            if (this.dataArrayList.get(i).getDate().equals(date)) {
                dataArrayList.add(this.dataArrayList.get(i));
            }
        }

        return dataArrayList;
    }

    /**
     * Gets the ArrayList from Data
     * @return dataArrayList Returns the ArrayList with the data
     */
    public ArrayList<Data> getDataArrayList() {
        return this.dataArrayList;
    }

    /**
     * Gets the last 10 items of the ArrayList
     * @return list Returns the list with the last 10 items from the ArrayList
     */
    public ArrayList<Data> getDataArrayListTest(){
        ArrayList<Data> list = new ArrayList<>();
        for (int i = this.dataArrayList.size() - 10; i < this.dataArrayList.size(); i++){
            list.add(this.dataArrayList.get(i));
        }
        return list;
    }

    /**
     * Get the dates from the File
     * @return dates Returns a list with the dates
     */
    public ArrayList<String> getDates(){
        ArrayList<String> dates = new ArrayList<>();
        dates.add(this.dataArrayList.get(0).getDate());

        int j = 0;

        for (int i = 1; i < this.dataArrayList.size(); i++)
        {
            if (!this.dataArrayList.get(i).getDate().equals(dates.get(j))){
                dates.add(this.dataArrayList.get(i).getDate());
                j++;
            }
        }
        return dates;
    }

    /**
     * Executes a new Thread to update the board
     */
    public void executeNewThread(){
        executeThread(()-> {
            for (int i = 0;  i < periods.size(); i++){
                try {
                    this.view.updateBoard(periods.get(i));
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * Creates a thread
     * @param runnable
     */
    public void executeThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    private int getMaxValue(){
        int maxValue = 0;
        for (int i = 0; i < dataArrayList.size(); i++){
            if (dataArrayList.get(i).getValue() > maxValue){
                maxValue = dataArrayList.get(i).getValue();
            }
        }

        return maxValue;
    }

    private int getMinValue(){
        int minValue = 0;

        for (int i = 0; i < dataArrayList.size(); i++){
            if (minValue == 0)
            {
                minValue = dataArrayList.get(i).getValue();
            }
            if (dataArrayList.get(i).getValue() < minValue){
                minValue = dataArrayList.get(i).getValue();
            }
        }

        return minValue;
    }

    private double getAverageNumberLines(){
        double averageNumberLines = 0;

        averageNumberLines = this.dataArrayList.size() / this.getDates().size();

        return averageNumberLines;
    }

    /**
     * Generate the file with the Statitics from the File
     * @throws IOException
     */
    public void generateDataFile() throws IOException {
        FileWriter fileWriter = new FileWriter("./files/generated/statisticData.txt");

        fileWriter.write("Number of data sets in file: " + getDates().size() + "\n");
        fileWriter.write("First Date: " + getDataArrayList().get(0).getDate() + "\n");
        fileWriter.write("Last Date: " + getDataArrayList().get(dataArrayList.size() - 1).getDate() + "\n");
        fileWriter.write("Average number of lines in each data set: " + this.getAverageNumberLines() + "\n");
        fileWriter.write("Number of columns in each data set: "  + ReadFile.getColumns() + "\n");
        fileWriter.write("Maximum value considering all data sets: " + this.getMaxValue() + "\n");
        fileWriter.write("Minimum value considering all data sets: " + this.getMinValue() + "\n");

        fileWriter.close();
    }
}