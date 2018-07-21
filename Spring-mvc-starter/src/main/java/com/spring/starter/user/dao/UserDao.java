package com.spring.starter.user.dao;

import java.util.List;

import com.spring.starter.models.Users;

public interface UserDao {

	public List<Users> fetchAllUsers();
}
