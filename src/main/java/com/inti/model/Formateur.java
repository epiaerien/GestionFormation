package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity

public class Formateur extends Utilisateurs {
	
	private boolean dispo;
	
	@OneToMany(mappedBy = "formateur", cascade = CascadeType.PERSIST)
	private List<Formation> formations;

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	
	
}
