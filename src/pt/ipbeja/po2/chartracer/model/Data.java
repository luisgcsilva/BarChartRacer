package pt.ipbeja.po2.chartracer.model;

import java.util.Objects;

public class Data implements Comparable<Data>{
    public String year;
    public String city;
    public String country;
    public int population;
    public String region;

    public Data(String year, String city, String country, int population, String region) {
        this.year = year;
        this.city = city;
        this.country = country;
        this.population = population;
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return year + "," + city + "," + country + "," + population + "," + region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return population == data.population && Objects.equals(year, data.year) && Objects.equals(city, data.city) && Objects.equals(country, data.country) && Objects.equals(region, data.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, city, country, population, region);
    }

    @Override
    public int compareTo(Data data) {

        if (data.getYear().equals(this.getYear())) {
            return data.getPopulation() - this.getPopulation();
        }

        return 0;

                /*(this.getPopulation() < city.getPopulation() ? -1:
                (this.getPopulation() == city.getPopulation() ? 0 : 1));*/
    }
}
