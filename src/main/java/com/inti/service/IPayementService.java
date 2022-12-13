package com.inti.service;

import java.util.List;

import com.inti.model.Payement;


public interface IPayementService {
	
	public void add(Payement u);
	public List<Payement> selectAll();
	public Payement selectById(int id);
	public void delete(int id);

}
