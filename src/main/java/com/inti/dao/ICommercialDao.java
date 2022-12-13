package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Commercial;

public interface ICommercialDao extends JpaRepository<Commercial, Integer>{

}
