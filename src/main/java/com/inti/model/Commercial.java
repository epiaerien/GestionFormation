package com.inti.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity

public class Commercial extends Utilisateurs {
	
	@OneToMany(mappedBy = "commercial")
	private List<RendezVous> rdv;
	
	@OneToMany(mappedBy = "commercial")
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
