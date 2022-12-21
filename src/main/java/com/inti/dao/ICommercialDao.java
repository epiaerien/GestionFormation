package com.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Commercial;

public interface ICommercialDao extends JpaRepository<Commercial, Integer>{
public Commercial findByAppelsProspect_id(int id); 
public Commercial findByRdvProspect_id(int id); 
 
}
