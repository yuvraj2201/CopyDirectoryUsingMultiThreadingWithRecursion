package com.locations;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "geolocations")
public class LocationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int xCordinates;
    private int yCordinates;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getxCordinates() {
        return xCordinates;
    }

    public void setxCordinates(int xCordinates) {
        this.xCordinates = xCordinates;
    }

    public int getyCordinates() {
        return yCordinates;
    }

    public void setyCordinates(int yCordinates) {
        this.yCordinates = yCordinates;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationsEntity{" +
                "id=" + id +
                ", xCordinates=" + xCordinates +
                ", yCordinates=" + yCordinates +
                ", location='" + location + '\'' +
                '}';
    }
}