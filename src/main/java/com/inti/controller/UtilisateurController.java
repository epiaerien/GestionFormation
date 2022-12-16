package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Utilisateurs;
import com.inti.service.IUtilisateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {

	@Autowired
	IUtilisateurService utService;

	@GetMapping("/utilisateurs")
	public List<Utilisateurs> getUtilisateurs() {

		List<Utilisateurs> utilisateurs = utService.selectAll();

		return utilisateurs;
	}

	@PostMapping("/utilisateurs")
	public void add(@RequestBody Utilisateurs u) {
		
		System.out.println(u.getNom());
		
		utService.add(u);

	}

	@GetMapping("/utilisateurs/{id}")
	public Utilisateurs selectById(@PathVariable("id") int id) {
		Utilisateurs u = utService.selectById(id);
		return u;

	}

	@DeleteMapping("/utilisateurs/{id}")
	public void delete(@PathVariable("id") int id) {
		utService.delete(id);
	}

}
