package com.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inti.model.Participant;

public interface IParticipantDao extends JpaRepository<Participant, Integer>{

}
