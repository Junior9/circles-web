package com.eg.circles.circles_web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.circles.circles_web.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>  {
	
	User findByLoginAndPassword(String login,String password);
}