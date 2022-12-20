package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.dao.IFormateurDao;
import com.inti.model.Formateur;
import com.inti.model.Formation;

@Service
public class FormateurService implements IFormateurService {

	@Autowired
	IFormateurDao foDao;

	@Override
	public Formateur chercherParFormationId(int id) {
		Formateur formateur = foDao.findByFormations_id(id);
		return formateur;
	}

	@Override
	public void add(Formateur f) {

		foDao.save(f);

	}

	@Override
	public List<Formateur> selectAll() {
		List<Formateur> formateurs = foDao.findAll();
		return formateurs;
	}

	@Override
	public Formateur selectById(int id) {
		Formateur formateur = foDao.findById(id).get();
		return formateur;
	}

	@Override
	public void delete(int id) {

		Formateur formateur = foDao.findById(id).get();

		List<Formation> fs = formateur.getFormations();
		for (Formation f : fs) {

			f.setFormateur(null);

		}
		
		formateur.setFormations(null);

		foDao.deleteById(id);

	}

}
