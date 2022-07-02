package pt.ipbeja.po2.chartracer.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadFile {
    File file;
    public ArrayList<Cities> cities = new ArrayList<>();

    public ReadFile(File file) {
        this.file = file;
    }

    public void readFile(File file){
        String nextLine;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(",")){
                    String[] data = nextLine.split(",");
                    cities.add(new Cities(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cities> getCities() {
        return this.cities;
    }


}
