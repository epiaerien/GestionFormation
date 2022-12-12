package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;




@Entity
public class Utilisateurs extends Personne {

	
	@ManyToOne
	Role role;
	
	String password;
	String username;
}
