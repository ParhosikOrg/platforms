package com.sap.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sap.platform.dao.UserDao;
import com.sap.platform.model.User;

@Service
public class UserService {
		
	@Autowired
	private UserDao userDao;
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User verify(User user) {
		return userDao.verify(user);
	}

}
