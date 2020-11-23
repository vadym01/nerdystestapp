package com.floorPlan.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActual;


    @OneToMany(mappedBy = "room",orphanRemoval = true)
    @JsonBackReference
    private List<Coordinates> coordinates = new ArrayList<>();



    public Room(Long id, boolean isActual, List<Coordinates> coordinates) {
        this.id = id;
        this.isActual = isActual;
        this.coordinates = coordinates;
    }

    public Room(boolean isActual, List<Coordinates> coordinates) {
        this.isActual = isActual;
        this.coordinates = coordinates;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }
}
