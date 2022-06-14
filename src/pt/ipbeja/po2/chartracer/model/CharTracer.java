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

    public ArrayList<String> cities = new ArrayList<>();

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

    //TO DO
    public ArrayList<String> getCitiesByYear(String year){
        ArrayList<String> citiesYear = new ArrayList<>();

        for (int i = 0; i < this.cities.size(); i++)
        {
            String string = cities.get(i).substring(0);
            String result = cities.get(i).substring(0, string.indexOf(','));

            if (result.equals(year))
            {
                citiesYear.add(string);
            }
        }

        return citiesYear;
    };

    public ArrayList<String> getCities() {
        return cities;
    }
}