package com.floorPlan.demo.entities.dto.dtoGetRequest;

public class GetAllCoordinatedDto {
    private Long coordinatesId;
    private int x;
    private int y;

    public GetAllCoordinatedDto(Long coordinatesId, int x, int y) {
        this.coordinatesId = coordinatesId;
        this.x = x;
        this.y = y;
    }

    public GetAllCoordinatedDto() {
    }

    public Long getCoordinatesId() {
        return coordinatesId;
    }

    public void setCoordinatesId(Long coordinatesId) {
        this.coordinatesId = coordinatesId;
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
