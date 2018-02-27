package com.wang.mapper;


import com.wang.model.Role;
import com.wang.model.UserRole;

public interface UserRoleMapper {

	void save(UserRole userRole);
	boolean delete(int id);
	Role findById(int id);

}
