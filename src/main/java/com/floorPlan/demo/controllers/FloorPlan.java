package com.floorPlan.demo.controllers;

import com.floorPlan.demo.entities.Room;
import com.floorPlan.demo.entities.dto.dtoGetRequest.GetAllRoomsDto;
import com.floorPlan.demo.entities.dto.dtoPostRequest.PostRoomDto;
import com.floorPlan.demo.repositories.CoordinatesRepository;
import com.floorPlan.demo.services.CoordinatesService;
import com.floorPlan.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
//@Validated
public class FloorPlan {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    private CoordinatesService coordinatesService;



    @PostMapping("/floorPlan")
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<PostRoomDto> postFloorPlan(@Valid @RequestBody PostRoomDto roomDto){
        roomService.createRoom(roomDto);
        return new ResponseEntity<PostRoomDto>(roomDto,HttpStatus.CREATED);

    }

    @PutMapping("floorPlan/{roomId}")
    public ResponseEntity changeRoomStatus(@PathVariable Long roomId){
        Room room = roomService.changeRoomStatusById(roomId);
        return new ResponseEntity(room,HttpStatus.OK);
    }
    

//    @PutMapping("/changeFloorPlan/{roomId}")
//    @ResponseBody
//    public ResponseEntity changeCoordinatesByRoomId(@PathVariable Long roomId,@RequestBody List<Coordinates> coordinates ){
//        List<Coordinates> coordinatesList = coordinatesService.changeCoordinatesByRoomId(roomId,coordinates);
//        return new ResponseEntity(coordinatesList,HttpStatus.OK);
//    }

    @DeleteMapping("/floorPlan/{roomId}")
    public ResponseEntity deleteRoomById(@PathVariable Long roomId){
        coordinatesService.deleteCoordinateByRoomId(roomId);
        return  new ResponseEntity(HttpStatus.OK);
    }
//
    @GetMapping("/floorPlan")
    public ResponseEntity getAllFlorPlans(){
        List<GetAllRoomsDto> floorPlanList = coordinatesService.getAllCoordinates();
        return new ResponseEntity(floorPlanList,HttpStatus.OK);
    }
}
