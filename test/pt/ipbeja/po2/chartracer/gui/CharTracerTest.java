package pt.ipbeja.po2.chartracer.gui;

import org.junit.jupiter.api.Test;
import pt.ipbeja.po2.chartracer.model.CharTracer;

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
}