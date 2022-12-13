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

import com.inti.model.Formateur;
import com.inti.service.IFormateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class FormateurController {
	
	@Autowired
	IFormateurService foService; 
	
	
	@GetMapping("/formateurs")
	public List<Formateur> getformateurs() {

		List<Formateur> formateurs = foService.selectAll();

		return formateurs;
	}

	@PostMapping("/formateurs")
	public void add(@RequestBody Formateur u) {

		foService.add(u);

	}

	@GetMapping("/formateurs/{id}")
	public Formateur selectById(@PathVariable("id") int id) {
		Formateur f = foService.selectById(id);
		return f;

	}

	@DeleteMapping("/formateurs/{id}")
	public void delete(@PathVariable("id") int id) {
		foService.delete(id);
	}

}
