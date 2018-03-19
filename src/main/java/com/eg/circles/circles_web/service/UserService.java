package com.eg.circles.circles_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.User;
import com.eg.circles.circles_web.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User login(User user) {
		user = userRepository.findByLoginAndPassword(user.getLogin(),user.getPassword());
		if(user == null){
			user = new User("","");
		}
		return user;
	}	
}