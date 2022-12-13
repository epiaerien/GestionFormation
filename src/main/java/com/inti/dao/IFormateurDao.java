package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Formateur;
import com.inti.model.Formation;

public interface IFormateurDao extends JpaRepository<Formateur, Integer>{

}
