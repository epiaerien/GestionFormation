package com.inti.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private float montant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_participant")
	@JsonIgnore
	private Participant participant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_payement")
	@JsonIgnore
	private Payement payement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Payement getPayement() {
		return payement;
	}

	public void setPayement(Payement payement) {
		this.payement = payement;
	}
	
	

}
