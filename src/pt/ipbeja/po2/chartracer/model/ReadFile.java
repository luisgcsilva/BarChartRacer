package pt.ipbeja.po2.chartracer.model;

import java.io.File;
import java.util.*;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class ReadFile {
    private File file;
    private static String title = "";

    public static ArrayList<Data> data = new ArrayList<>();

    /**
     * Constructor of the class ReadFile
     * @param file The File to be read
     */
    public ReadFile(File file) {
        this.file = file;
    }

    /**
     * Reads the File and stores the data in ArrayList from Data objects
     * @param file The File to be read
     * @return data The ArrayList of Data objects with the data from the File
     */
    public static ArrayList<Data> readFile(File file){
        String nextLine;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(",")){
                    String[] line = nextLine.split(",");
                    if (line.length > 3){
                    data.add(new Data(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4]));
                    }
                }
                else
                {
                    if (title.isEmpty()){
                        title = nextLine;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static String getTitle(){
        return title;
    }
}
