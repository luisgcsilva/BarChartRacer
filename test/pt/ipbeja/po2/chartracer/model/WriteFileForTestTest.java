package pt.ipbeja.po2.chartracer.model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WriteFileForTestTest {

    @Test
    void testWriteFile() throws IOException {
        File citiesFile = new File("./files/datafiles/cities.txt");
        ChartRacer chartRacer = new ChartRacer(null, citiesFile);
        WriteFileForTest writeFileForTest = new WriteFileForTest(chartRacer.getDataArrayList());
        writeFileForTest.writeFile();

        File file2 = new File("./files/generated/orderedData.txt");
        ChartRacer chartRacer1 = new ChartRacer(null, file2);
        ArrayList<Data> list = chartRacer1.getDataArrayListTest();

        ArrayList<Data> expectedList = new ArrayList<>();
        expectedList.add(new Data("1500", "Beijing", "China", 672, "East Asia"));
        expectedList.add(new Data("1500", "Vijayanagar", "India", 500, "South Asia"));
        expectedList.add(new Data("1500", "Cairo" ,"Egypt", 400, "Middle East"));
        expectedList.add(new Data("1500", "Hangzhou", "China", 250, "East Asia"));
        expectedList.add(new Data("1500", "Tabriz", "Iran", 250, "Middle East"));
        expectedList.add(new Data("2018", "Tokyo", "Japan", 38194, "East Asia"));
        expectedList.add(new Data("2018", "Delhi", "India", 27890, "South Asia"));
        expectedList.add(new Data("2018", "Shanghai", "China", 25779, "East Asia"));
        expectedList.add(new Data("2018", "Beijing", "China", 22674, "East Asia"));
        expectedList.add(new Data("2018", "Mumbai", "India", 22120, "South Asia"));

        assertEquals(expectedList, list);
    }
}