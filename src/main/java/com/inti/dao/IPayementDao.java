package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Payement;

public interface IPayementDao extends JpaRepository<Payement, Integer>{

}
