package com.floorPlan.demo.entities.dto.dtoGetRequest;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class CoordinatesDto {

    private int x;
    private int y;

    public CoordinatesDto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CoordinatesDto() {
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
}
