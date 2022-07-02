package pt.ipbeja.po2.chartracer.model;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {
    @Test
    void testReadFile() {
        File file = new File("./files/cities.txt");
        ReadFile readFile = new ReadFile(file);
        readFile.readFile(file);
        ArrayList<Cities> citiesArrayList = readFile.getCities();
        ArrayList<Cities> cities = new ArrayList<>();

        cities.add(new Cities("1500", "Beijing", "China", 672, "East Asia"));
        cities.add(new Cities("2018", "Tokyo", "Japan", 38194, "East Asia"));
        String test = cities.get(0).toString();
        String test1 = citiesArrayList.get(0).toString();

        assertEquals(cities.get(0), citiesArrayList.get(0));
        assertEquals(cities.get(1), citiesArrayList.get(citiesArrayList.size() - 1));
    }
}