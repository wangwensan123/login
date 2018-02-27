package com.wang.service;


import com.wang.model.UserRole;


public interface UserRoleService {
	void save(UserRole userRole);
	boolean delete(int id);
	UserRole findById(int id);

}
