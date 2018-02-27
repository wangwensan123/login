package com.wang.mapper;

import java.util.List;

import com.wang.model.Role;

public interface RoleMapper {

	void save(Role role);
	boolean update(Role role);
	boolean delete(int id);
	Role findById(int id);
	Role findByName(String rolename);
	List<Role> findAll();
}
