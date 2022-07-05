package pt.ipbeja.po2.chartracer.model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChartRacerTest {
/*
    @Test
    void testOderData() {
        File file = new File("./files/cities.txt");
        ReadFile readFile = new ReadFile(file);
        readFile.readFile(file);
        ChartRacer chartRacer = new ChartRacer(file);
        ArrayList<Data> list = chartRacer.orderList(readFile.getCities());
        ArrayList<Data> list1500 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            if (list.get(i).year.equals("1500"))
                list1500.add(list.get(i));
        }

        ArrayList<Data> expectedList1500 = new ArrayList<>();
        expectedList1500.add(new Data("1500", "Beijing", "China", 672, "East Asia"));
        expectedList1500.add(new Data("1500", "Vijayanagar", "India", 500, "South Asia"));
        expectedList1500.add(new Data("1500", "Cairo" ,"Egypt", 400, "Middle East"));
        expectedList1500.add(new Data("1500", "Hangzhou", "China", 250, "East Asia"));
        expectedList1500.add(new Data("1500", "Tabriz", "Iran", 250, "Middle East"));
        expectedList1500.add(new Data("1500", "Gauda", "India", 200, "South Asia"));
        expectedList1500.add(new Data("1500", "Istanbul", "Turkey", 200, "Europe"));
        expectedList1500.add(new Data("1500", "Paris", "France", 185, "Europe"));
        expectedList1500.add(new Data("1500", "Guangzhou", "China", 150, "East Asia"));
        expectedList1500.add(new Data("1500", "Nanjing", "China", 147, "East Asia"));
        expectedList1500.add(new Data("1500", "Cuttack", "India", 140, "South Asia"));
        expectedList1500.add(new Data("1500","Fez", "Morocco", 130, "Middle East"));

        assertEquals(expectedList1500, list1500);

        ArrayList<Data> list2018 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++)
        {
            if (list.get(i).year.equals("2018"))
                list2018.add(list.get(i));
        }

        ArrayList<Data> expectedList2018 = new ArrayList<>();
        expectedList2018.add(new Data("2018", "Tokyo", "Japan", 38194, "East Asia"));
        expectedList2018.add(new Data("2018", "Delhi", "India", 27890, "South Asia"));
        expectedList2018.add(new Data("2018", "Shanghai", "China", 25779, "East Asia"));
        expectedList2018.add(new Data("2018", "Beijing", "China", 22674, "East Asia"));
        expectedList2018.add(new Data("2018", "Mumbai", "India", 22120, "South Asia"));
        expectedList2018.add(new Data("2018", "São Paulo" ,"Brazil", 21698, "Latin America"));
        expectedList2018.add(new Data("2018", "Mexico City", "Mexico", 21520, "Latin America"));
        expectedList2018.add(new Data("2018", "Osaka", "Japan",20409, "East Asia"));
        expectedList2018.add(new Data("2018", "Cairo", "Egypt", 19850, "Middle East"));
        expectedList2018.add(new Data("2018", "Dhaka", "Bangladesh", 19633, "South Asia"));
        expectedList2018.add(new Data("2018", "New York", "United States",18713, "North America"));
        expectedList2018.add(new Data("2018","Karachi", "Pakistan", 18185, "South Asia"));

        assertEquals(expectedList2018, list2018);
    }

    @Test
    void testWriteOrderedFile() throws IOException {
        File file = new File("./files/cities.txt");
        ReadFile readFile = new ReadFile(file);
        readFile.readFile(file);
        ChartRacer chartRacer = new ChartRacer(file);
        chartRacer.orderList(readFile.getCities());
        WriteDataFile writeDataFile = new WriteDataFile(readFile.getCities());
        writeDataFile.writeFile();
        File file2 = new File("./files/orderedData.txt");
        ReadFile readFile1 = new ReadFile(file2);
        readFile1.readFile(file2);
        ArrayList<Data> list = readFile1.getCities();

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
    }*/
}