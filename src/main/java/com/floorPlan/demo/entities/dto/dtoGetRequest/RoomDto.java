package com.floorPlan.demo.entities.dto.dtoGetRequest;

import java.util.ArrayList;
import java.util.List;

public class RoomDto {

   private List<GetAllCoordinatedDto> room = new ArrayList<>();

    public RoomDto(List<GetAllCoordinatedDto> room) {
        this.room = room;
    }

    public RoomDto() {
    }

    public List<GetAllCoordinatedDto> getRoom() {
        return room;
    }

    public void setRoom(List<GetAllCoordinatedDto> room) {
        this.room = room;
    }
}
