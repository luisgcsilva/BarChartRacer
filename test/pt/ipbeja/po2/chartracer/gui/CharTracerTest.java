package pt.ipbeja.po2.chartracer.gui;

import org.junit.jupiter.api.Test;
import pt.ipbeja.po2.chartracer.model.CharTracer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharTracerTest {

    @Test
    void testReadFile() {
        CharTracer charTracer = new CharTracer();
        String firstLine = charTracer.getCities().get(0);
        String lastLine = charTracer.getCities().get(charTracer.cities.size() - 1);

        assertEquals("1500,Beijing,China,672,East Asia", firstLine);
        assertEquals("2018,Tokyo,Japan,38194,East Asia", lastLine);
    }

    @Test
    void testDataFromMoments() {
        CharTracer charTracer = new CharTracer();
        ArrayList<String> cities1 = charTracer.getCitiesByYear("1500");
        ArrayList<String> cities2 = charTracer.getCitiesByYear("2018");

        ArrayList<String> firstCities = new ArrayList<>();
        firstCities.add("1500,Beijing,China,672,East Asia");
        firstCities.add("1500,Cairo,Egypt,400,Middle East");
        firstCities.add("1500,Cuttack,India,140,South Asia");
        firstCities.add("1500,Fez,Morocco,130,Middle East");
        firstCities.add("1500,Gauda,India,200,South Asia");
        firstCities.add("1500,Guangzhou,China,150,East Asia");
        firstCities.add("1500,Hangzhou,China,250,East Asia");
        firstCities.add("1500,Istanbul,Turkey,200,Europe");
        firstCities.add("1500,Nanjing,China,147,East Asia");
        firstCities.add("1500,Paris,France,185,Europe");
        firstCities.add("1500,Tabriz,Iran,250,Middle East");
        firstCities.add("1500,Vijayanagar,India,500,South Asia");

        ArrayList<String > lastCities = new ArrayList<>();
        lastCities.add("2018,Beijing,China,22674,East Asia");
        lastCities.add("2018,Cairo,Egypt,19850,Middle East");
        lastCities.add("2018,Delhi,India,27890,South Asia");
        lastCities.add("2018,Dhaka,Bangladesh,19633,South Asia");
        lastCities.add("2018,Karachi,Pakistan,18185,South Asia");
        lastCities.add("2018,Mexico City,Mexico,21520,Latin America");
        lastCities.add("2018,Mumbai,India,22120,South Asia");
        lastCities.add("2018,New York,United States,18713,North America");
        lastCities.add("2018,Osaka,Japan,20409,East Asia");
        lastCities.add("2018,Shanghai,China,25779,East Asia");
        lastCities.add("2018,São Paulo,Brazil,21698,Latin America");
        lastCities.add("2018,Tokyo,Japan,38194,East Asia");

        assertEquals(firstCities, cities1);
        System.out.println("Esperado 1: " + firstCities);
        System.out.println("Esperado 2: " + cities1);

        assertEquals(lastCities, cities2);
        System.out.println("Esperado 1: " + lastCities);
        System.out.println("Esperado 2: " + cities2);


        String text = "1500,Beijing,China,672,East Asia";
        String result = text.substring(0, text.indexOf(','));
        assertEquals("1500", result);

        String text2 = "2018,Tokyo,Japan,38194,East Asia";
        String result2 = text2.substring(0, text2.indexOf(','));
        assertEquals("2018", result2);
    }
}