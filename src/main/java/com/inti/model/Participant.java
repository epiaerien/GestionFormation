package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Participant extends Utilisateurs{
	
	
	@ManyToMany(mappedBy = "participants",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Formation> formations;
	
	@OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "diplomes_participants",
	joinColumns = @JoinColumn(name="id_participant"),
	inverseJoinColumns = @JoinColumn(name="id_diplome"))
	//suppression json ignore car deja dans diplomes model
	//@JsonIgnore
	private List<Diplome>  diplomes;

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}
	
	
	

}
