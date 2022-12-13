package com.inti.service;

import java.util.List;

import com.inti.model.Formation;

public interface IFormationService {

	void add(Formation form);

	List<Formation> selectAll();

	Formation selectById(int id);

	void delete(int id);

}