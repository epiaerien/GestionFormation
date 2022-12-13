package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.dao.IRoleDao;
import com.inti.model.Role;

public class RoleService implements IRoleService{
	
	@Autowired
	IRoleDao roDao;

	@Override
	public void add(Role r) {
		
		roDao.save(r);
		
	}

	@Override
	public List<Role> selectAll() {
		List<Role> roles = roDao.findAll();
		return roles;
	}

	@Override
	public Role selectById(int id) {
		
		Role r  = roDao.findById(id).get();
		
		return r;
	}

	@Override
	public void delete(int id) {
		
		roDao.deleteById(id);
		
	}

}
