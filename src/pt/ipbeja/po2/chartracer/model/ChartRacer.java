package pt.ipbeja.po2.chartracer.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ChartRacer {

    private ArrayList<Cities> cities;
    private ReadFile readFile;

    public ChartRacer(File file){
        this.readFile = new ReadFile(file);
        this.cities = readFile.getCities();
        this.readFile.readFile(file);
        this.cities = this.orderList(this.cities);
        try {
            writeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cities> orderList(ArrayList<Cities> list){
        int j;
        for (int i = 1; i < list.size(); i++){
            Cities key = list.get(i);
            j = i;
            while ((j > 0) && list.get(j - 1).population < key.population){
                if (list.get(j - 1).year.equals(key.year)){
                    list.set(j, list.get(j - 1));
                    j--;
                }
                else {break;}
            }
            list.set(j, key);
        }

        //Collections.sort(list, Collections.reverseOrder());

        return list;
    }

    public void writeFile() throws IOException {
        FileWriter fileWriter = new FileWriter("./files/orderedData.txt");

        for (int i = 0; i < 5; i++) {
            fileWriter.write(this.cities.get(i).toString() + "\n");
        }
        int counter = 0;
        for (int i = 0; i < this.cities.size(); i++)
        {
            if (counter < 5)
            {
                if (this.cities.get(i).year.equals("2018")){
                    fileWriter.write(this.cities.get(i).toString() + "\n");
                    counter++;
                }
            } else {
                break;
            }
        }
        fileWriter.close();
    }

/*
    private void readFile(File file){
        String nextLine;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(",")){
                    String[] data = nextLine.split(",");
                    cities.add(new Cities(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), data[4]));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
*/

}