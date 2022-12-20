package com.inti.service;

import java.util.List;

import com.inti.model.Appel;


public interface IAppelService {

	
	public void add(Appel a);
	public List<Appel> selectAll();
	public Appel selectById(int id);
	public void delete(int id);
	
	public List<Appel> getbyidcommercial(int id);
	
}
