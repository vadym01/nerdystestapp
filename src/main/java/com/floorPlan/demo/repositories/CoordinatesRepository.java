package com.floorPlan.demo.repositories;

import com.floorPlan.demo.entities.Coordinates;
import com.floorPlan.demo.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoordinatesRepository extends JpaRepository<Coordinates,Long> {
    List<Coordinates> findCoordinatesByRoom(Room room);

}
