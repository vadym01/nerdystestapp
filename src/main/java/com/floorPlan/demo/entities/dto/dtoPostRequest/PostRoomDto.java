package com.floorPlan.demo.entities.dto.dtoPostRequest;

import com.floorPlan.demo.entities.dto.dtoGetRequest.CoordinatesDto;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class PostRoomDto {

    @Size(min = 4,message = "wrong input value(s): required minimum 4 x|y coordinates")
    private List<CoordinatesDto> room = new ArrayList<>();



    public PostRoomDto(List<CoordinatesDto> room) {
        this.room = room;
    }

    public PostRoomDto() {
    }


    public List<CoordinatesDto> getRoom() {
        return room;
    }

    public void setRoom(List<CoordinatesDto> room) {
        this.room = room;
    }
}
