package com.inti.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Personne {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
	String adresse;
	String mail;
	Date date;
	

}
