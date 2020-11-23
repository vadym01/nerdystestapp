package com.floorPlan.demo.services;

import com.floorPlan.demo.entities.Coordinates;
import com.floorPlan.demo.entities.Room;
import com.floorPlan.demo.entities.dto.dtoGetRequest.GetAllRoomsDto;

import java.util.List;

public interface CoordinatesService {
    void deleteCoordinateByRoomId(Long id);
    List<GetAllRoomsDto> getAllCoordinates();
    Room findRoomById(Long id);
    List<Coordinates> findAllCoordinatesByRoom(Room room);
}
