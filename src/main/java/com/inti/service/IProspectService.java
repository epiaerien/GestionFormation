package com.inti.service;

import java.util.List;

import com.inti.model.Prospect;

public interface IProspectService {

	public void add(Prospect p);
	public List<Prospect> selectAll();
	public Prospect selectById(int id);
	public void delete(int id);
}
