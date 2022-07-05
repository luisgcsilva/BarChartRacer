package pt.ipbeja.po2.chartracer.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    File file;
    public static ArrayList<Data> data = new ArrayList<>();

    public ReadFile(File file) {
        this.file = file;
    }

    public static ArrayList<Data> readFile(File file){
        String nextLine;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(",")){
                    String[] line = nextLine.split(",");
                    data.add(new Data(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4]));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
