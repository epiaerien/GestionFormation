package com.inti.service;

import java.util.List;

import com.inti.model.Role;

public interface IRoleService {
	
	public void add(Role r);
	public List<Role> selectAll();
	public Role selectById(int id);
	public void delete(int id);

}
