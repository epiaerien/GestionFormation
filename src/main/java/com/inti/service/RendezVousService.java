package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IRendezVousDao;
import com.inti.model.RendezVous;

@Service
public class RendezVousService implements IRendezVousService {
	
	@Autowired
	IRendezVousDao rdvDao;
	
	
	@Override
	public void add(RendezVous rdv) {
		rdvDao.save(rdv);
	}
	
	
	@Override
	public List<RendezVous> selectAll(){
		List<RendezVous> rdvs = rdvDao.findAll();
		return rdvs;		
	}
	
	
	@Override
	public RendezVous selectById(int id) {
		RendezVous rdv = rdvDao.findById(id).get();
		return rdv;
	}
	
	
	@Override
	public void delete(int id) {
		rdvDao.deleteById(id);
	}

}
