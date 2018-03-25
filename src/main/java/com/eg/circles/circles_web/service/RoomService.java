package com.eg.circles.circles_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Room;
import com.eg.circles.circles_web.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public Iterable<Room> getAll() {
		return roomRepository.findAll();
	}

	public Room get(int idRoom) {
		return roomRepository.findOne(String.valueOf(idRoom));
	}

	public void delete(int idRoom) {
		roomRepository.delete(String.valueOf(idRoom));
	}

	public Room save(Room room) {
		return roomRepository.save(room);
	}
}