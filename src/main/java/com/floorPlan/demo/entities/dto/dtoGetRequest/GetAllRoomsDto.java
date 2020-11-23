package com.floorPlan.demo.entities.dto.dtoGetRequest;

import java.util.List;

public class GetAllRoomsDto extends RoomDto {

        private Long roomId;
        private boolean isActual;

    public GetAllRoomsDto(Long roomId, boolean isActual,List<GetAllCoordinatedDto> room) {
        super(room);
        this.roomId = roomId;
        this.isActual = isActual;
    }

    public GetAllRoomsDto(List<GetAllCoordinatedDto> room) {
        super(room);
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }
}
