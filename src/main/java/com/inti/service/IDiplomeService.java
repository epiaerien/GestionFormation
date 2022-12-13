package com.inti.service;

import java.util.List;

import com.inti.model.Diplome;


public interface IDiplomeService {
	
	public void add(Diplome u);
	public List<Diplome> selectAll();
	public Diplome selectById(int id);
	public void delete(int id);

}
