package com.inti.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Diplome {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	@Temporal(TemporalType.DATE)
	private Date dateOpt;
	
	@OneToOne
	@JoinColumn(name = "id_formation")
	private Formation formation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_participant")
	@JsonIgnore
	private Participant participant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateOpt() {
		return dateOpt;
	}

	public void setDateOpt(Date dateOpt) {
		this.dateOpt = dateOpt;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	

}
