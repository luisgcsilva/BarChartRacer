package pt.ipbeja.po2.chartracer.model;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

class ReadFileTest {
    @Test
    void testReadFile() {
        File file = new File("./files/cities.txt");
        ReadFile readFile = new ReadFile(file);
        ArrayList<Data> dataArrayList = readFile.readFile(file);
        ArrayList<Data> cities = new ArrayList<>();

        cities.add(new Data("1500", "Beijing", "China", 672, "East Asia"));
        cities.add(new Data("2018", "Tokyo", "Japan", 38194, "East Asia"));

        assertEquals(cities.get(0), dataArrayList.get(0));
        assertEquals(cities.get(1), dataArrayList.get(dataArrayList.size() - 1));
    }
}