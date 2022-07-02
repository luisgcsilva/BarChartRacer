package pt.ipbeja.po2.chartracer.model;

import java.util.Objects;

public class Cities implements Comparable<Cities>{
    public String year;
    public String city;
    public String country;
    public int population;
    public String region;

    public Cities(String year, String city, String country, int population, String region) {
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
        if (!(o instanceof Cities)) return false;
        Cities cities = (Cities) o;
        return population == cities.population && Objects.equals(year, cities.year) && Objects.equals(city, cities.city) && Objects.equals(country, cities.country) && Objects.equals(region, cities.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, city, country, population, region);
    }

    @Override
    public int compareTo(Cities city) {
        return (this.getPopulation() < city.getPopulation() ? -1:
                (this.getPopulation() == city.getPopulation() ? 0 : 1));
    }
}
