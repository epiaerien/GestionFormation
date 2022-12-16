package com.inti.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Formateur;
import com.inti.model.Formation;
import com.inti.service.IFormateurService;
import com.inti.service.IFormationService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class FormationController {

	@Autowired
	IFormationService formationService;
	
	@Autowired
	IFormateurService formateurService; 

	@GetMapping("/formations")
	public List<Formation> getAssistants() {

		List<Formation> formations = formationService.selectAll();

		return formations;
	}

	@PostMapping("/formations")
	public void add(@RequestBody Formation form) {

		formationService.add(form);

	}

	@GetMapping("/formations/{id}")
	public Formation selectById(@PathVariable("id") int id) {
		Formation form = formationService.selectById(id);
		return form;

	}

	@DeleteMapping("/formations/{id}")
	public void delete(@PathVariable("id") int id) {
		formationService.delete(id);
	}
	
	@GetMapping("/formateurParFormation/{id}")
	public Formateur selectbyformation(@PathVariable("id") int id )
	{
		
		Formateur formateur = formateurService.chercherParFormationId(id); 
		System.out.println(formateur.getNom());
		return formateur; 
	}
	
	@GetMapping("/formationsbyPart/{id}")
	public Set<Formation> getFormationByPartId(@PathVariable("id") int id ) {

		Set<Formation> formations = formationService.getByidParticipants(id);

		return formations;
	}
	
}
