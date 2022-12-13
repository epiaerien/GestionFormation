package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Role;

public interface IRoleDao extends JpaRepository<Role, Integer>{

}
