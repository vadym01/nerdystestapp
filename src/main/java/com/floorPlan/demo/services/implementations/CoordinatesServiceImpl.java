package com.floorPlan.demo.services.implementations;

import com.floorPlan.demo.entities.Coordinates;
import com.floorPlan.demo.entities.Room;
import com.floorPlan.demo.entities.dto.dtoGetRequest.GetAllCoordinatedDto;
import com.floorPlan.demo.entities.dto.dtoGetRequest.GetAllRoomsDto;
import com.floorPlan.demo.repositories.CoordinatesRepository;
import com.floorPlan.demo.repositories.RoomRepository;
import com.floorPlan.demo.services.CoordinatesService;
import com.floorPlan.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    private CoordinatesService coordinatesService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private  RoomRepository roomRepository;

    @Override
    public void deleteCoordinateByRoomId(Long id) {
        Room room = roomService.findRoomById(id);
        List<Coordinates> coordinatesList = coordinatesRepository.findCoordinatesByRoom(room);
        coordinatesRepository.deleteAll(coordinatesList);
    }

    @Override
    public Room findRoomById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public List<GetAllRoomsDto> getAllCoordinates() {
        List<GetAllRoomsDto> roomDtoList = new ArrayList<>();
        roomRepository.findAll().forEach(room -> {
            List<Coordinates> coordinatesList =  findAllCoordinatesByRoom(room);
            List<GetAllCoordinatedDto> getAllCoordinatedDto = new ArrayList<>();
            coordinatesList.forEach(coordinates -> {
                GetAllCoordinatedDto getAllCoordinatedDto1 = new GetAllCoordinatedDto(coordinates.getId(),coordinates.getX(),coordinates.getY());
                getAllCoordinatedDto.add(getAllCoordinatedDto1);
            });

            GetAllRoomsDto getAllRoomsDto = new GetAllRoomsDto(room.getId(),room.isActual(),getAllCoordinatedDto);
            roomDtoList.add(getAllRoomsDto);
        });
        return roomDtoList;
    }

    @Override
    public List<Coordinates> findAllCoordinatesByRoom(Room room) {
        return coordinatesRepository.findCoordinatesByRoom(room);
    }
}
