package com.inti.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("P")
public class Prospect extends Personne{
	
	@OneToMany(mappedBy = "prospect")
	private List<RendezVous> rdv;
	
	@OneToMany(mappedBy = "prospect")
	private List<Appel> appels;

	public List<RendezVous> getRdv() {
		return rdv;
	}

	public void setRdv(List<RendezVous> rdv) {
		this.rdv = rdv;
	}

	public List<Appel> getAppels() {
		return appels;
	}

	public void setAppels(List<Appel> appels) {
		this.appels = appels;
	}
	
	

}
