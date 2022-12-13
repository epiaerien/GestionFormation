package com.inti.service;

import java.util.List;

import com.inti.model.Assistant;




public interface IAssistantService {
	
	public void add(Assistant u);
	public List<Assistant> selectAll();
	public Assistant selectById(int id);
	public void delete(int id);

}
