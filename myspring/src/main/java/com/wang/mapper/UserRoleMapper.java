package com.wang.mapper;

import com.wang.model.UserRole;

public interface UserRoleMapper {

	void save(UserRole userRole);
	boolean delete(int id);
	UserRole findById(int id);

}
