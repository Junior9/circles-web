package com.eg.circles.circles_web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Room;
import com.eg.circles.circles_web.repository.RoomRepository;

@Service
public class RoomService {

//	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Room get(int idRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int idRoom) {
		// TODO Auto-generated method stub
	}

	public Room save(Room room) {
		// TODO Auto-generated method stub
		return null;
	}
}