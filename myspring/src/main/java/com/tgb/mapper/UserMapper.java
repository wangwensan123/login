package com.tgb.mapper;

import java.util.List;

import com.tgb.model.User;

public interface UserMapper {

	void save(User user);
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);
	User findByName(String username);
	List<User> findAll();
}
