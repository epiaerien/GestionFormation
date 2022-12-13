package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Appel;

public interface IAppelDao extends JpaRepository<Appel, Integer>{

}
