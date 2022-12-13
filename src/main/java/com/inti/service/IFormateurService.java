package com.inti.service;

import java.util.List;

import com.inti.model.Formateur;

public interface IFormateurService {
	public void add(Formateur f);
	public List<Formateur> selectAll();
	public Formateur selectById(int id);
	public void delete(int id);
}
