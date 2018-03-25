package com.eg.circles.circles_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Room;
import com.eg.circles.circles_web.service.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;

	@GetMapping("/room/all")
	public Iterable<Room> getAll(){
		return roomService.getAll();
	}

	@GetMapping("/room/get/{idRoom}")
	public Room get(@PathVariable int idRoom) {
		return roomService.get(idRoom);
	}
	
	@PostMapping(value="/room/save",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Room save(@RequestBody Room room) {
		return roomService.save(room);
	}
	
	@DeleteMapping("/room/delete/{idRoom}")
	public void delete(@PathVariable int idRoom) {
		roomService.delete(idRoom);
	}
}