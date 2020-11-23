package com.floorPlan.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity

public class Coordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int x;
    private int y;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="room_id")
//    @JsonBackReference
    @JsonManagedReference
    private Room room;


    public Coordinates(int x, int y, Room room) {
        this.x = x;
        this.y = y;
        this.room = room;
    }

    public Coordinates(Long id, int x, int y, Room room) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.room = room;
    }

    public Coordinates() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
