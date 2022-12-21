package com.inti.service;

import java.util.List;

import com.inti.model.Commercial;


public interface ICommercialService {
	
	public void add(Commercial c);
	public List<Commercial> selectAll();
	public Commercial selectById(int id);
	public void delete(int id);
	public Commercial commercialparappel(int id);
	

	public Commercial commercialparrdv(int id);
}
