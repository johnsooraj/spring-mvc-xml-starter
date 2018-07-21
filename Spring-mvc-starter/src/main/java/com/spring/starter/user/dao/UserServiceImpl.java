package com.spring.starter.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.starter.models.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<Users> fetchAllUsers() {
		return userDao.fetchAllUsers();
	}

}
