package com.floorPlan.demo.repositories;

import com.floorPlan.demo.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
