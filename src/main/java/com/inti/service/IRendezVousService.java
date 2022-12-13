package com.inti.service;

import java.util.List;

import com.inti.model.RendezVous;

public interface IRendezVousService {

	void add(RendezVous rdv);

	List<RendezVous> selectAll();

	RendezVous selectById(int id);

	void delete(int id);

}