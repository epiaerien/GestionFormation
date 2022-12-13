package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Participant extends Utilisateurs{
	
	
	@ManyToMany(mappedBy = "participants")
	private List<Formation> formations;
	
	@OneToMany(mappedBy = "participant")
	private List<Transaction> transactions;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_diplome")
	@JsonIgnore
	private Diplome diplome;

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

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
	
	
	

}
