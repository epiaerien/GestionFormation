package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Assistant;

public interface IAssistantDao extends JpaRepository<Assistant, Integer> {

}
