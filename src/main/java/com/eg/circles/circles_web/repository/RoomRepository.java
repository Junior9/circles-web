package com.eg.circles.circles_web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.circles.circles_web.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

}
