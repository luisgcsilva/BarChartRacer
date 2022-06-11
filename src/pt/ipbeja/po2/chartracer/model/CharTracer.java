package pt.ipbeja.po2.chartracer.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CharTracer {

    public List<String> cities = new ArrayList<>();
    List<String> data = new ArrayList<>();
    String nextLine;

    public CharTracer(){

        try {
            Scanner scanner = new Scanner(new File("file/cities.txt"));
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(",")){
                    cities.add(nextLine.substring(0));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done");
    }

    public List<String> getCities() {
        return cities;
    }
}