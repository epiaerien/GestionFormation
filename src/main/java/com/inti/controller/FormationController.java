package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Formation;

import com.inti.service.IFormationService;

@Controller
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class FormationController {

	@Autowired
	IFormationService formationService;

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
}
