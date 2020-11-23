package com.floorPlan.demo.services.implementations;

import com.floorPlan.demo.entities.Coordinates;
import com.floorPlan.demo.entities.Room;
import com.floorPlan.demo.entities.dto.dtoGetRequest.RoomDto;
import com.floorPlan.demo.entities.dto.dtoPostRequest.PostRoomDto;
import com.floorPlan.demo.repositories.CoordinatesRepository;
import com.floorPlan.demo.repositories.RoomRepository;
import com.floorPlan.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Override
    public void createRoom(PostRoomDto roomDto) {
        Room room = new Room();
        List<Coordinates> coordinatesList = new ArrayList<>();
        roomDto.getRoom().forEach(coordinatesDto -> {
            Coordinates coordinates = new Coordinates(coordinatesDto.getX(),coordinatesDto.getY(),room);
            coordinatesList.add(coordinates);
        });
        coordinatesRepository.saveAll(coordinatesList);
    }



    @Override
    public Room findRoomById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public Room changeRoomStatusById(Long id) {
        Room room = findRoomById(id);

        room.setActual(!room.isActual());
        roomRepository.save(room);
        return room;
    }
}
