package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IAssistantDao;
import com.inti.model.Assistant;




@Service
public class AssistantService implements IAssistantService{
	
	@Autowired
	IAssistantDao assistantDao;
	
	@Override
	public void add(Assistant ass) {
		assistantDao.save(ass);
	}
	
	@Override
	public List<Assistant> selectAll(){
		List<Assistant> assistants = assistantDao.findAll();
		return assistants;		
	}
	
	@Override
	public Assistant selectById(int id) {
		Assistant assistant = assistantDao.findById(id).get();
		return assistant;
	}
	
	
	public void delete(int id) {
		assistantDao.deleteById(id);
	}

}
