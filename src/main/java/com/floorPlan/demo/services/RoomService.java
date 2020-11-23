package com.floorPlan.demo.services;

import com.floorPlan.demo.entities.Room;
import com.floorPlan.demo.entities.dto.dtoPostRequest.PostRoomDto;

public interface RoomService {
    void createRoom(PostRoomDto roomDto);
    Room findRoomById(Long id);
    Room changeRoomStatusById(Long id);
}
