package pt.ipbeja.po2.chartracer.model;

import javafx.scene.paint.Color;
import java.util.Objects;

/**
 * @author Luís Gabriel da Cruz Silva
 * @number 19314
 * @version 06/07/2022
 */

public class Data implements Comparable<Data>{
    private int value;
    private String date;
    private String city;
    private String country;
    private String region;
    private Color color;

    /**
     * Constructor of the Object Data
     * @param date
     * @param city
     * @param country
     * @param value
     * @param region
     */
    public Data(String date, String city, String country, int value, String region) {
        this.date = date;
        this.city = city;
        this.country = country;
        this.value = value;
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return date + "," + city + "," + country + "," + value + "," + region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return value == data.value && Objects.equals(date, data.date) && Objects.equals(city, data.city) && Objects.equals(country, data.country) && Objects.equals(region, data.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, city, country, value, region);
    }

    @Override
    public int compareTo(Data data) {

        if (data.getDate().equals(this.getDate())) {
            return data.getValue() - this.getValue();
        }

        return 0;
    }
}
