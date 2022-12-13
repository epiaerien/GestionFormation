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


import com.inti.model.RendezVous;
import com.inti.service.IRendezVousService;

@Controller
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RendezVousController {
	
	@Autowired
	IRendezVousService rdvService;

	@GetMapping("/rendezvous")
	public List<RendezVous> getAssistants() {

		List<RendezVous> rdv = rdvService.selectAll();

		return rdv;
	}

	@PostMapping("/rendezvous")
	public void add(@RequestBody RendezVous rdv) {

		rdvService.add(rdv);

	}

	@GetMapping("/rendezvous/{id}")
	public RendezVous selectById(@PathVariable("id") int id) {
		RendezVous rdv = rdvService.selectById(id);
		return rdv;

	}

	@DeleteMapping("/rendezvous/{id}")
	public void delete(@PathVariable("id") int id) {
		rdvService.delete(id);
	}

}
