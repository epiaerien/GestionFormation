package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Prospect;

public interface IProspectDao extends JpaRepository<Prospect, Integer>{

}
