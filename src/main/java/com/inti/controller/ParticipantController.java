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

import com.inti.model.Participant;
import com.inti.service.IParticipantService;



@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ParticipantController {

	@Autowired
	IParticipantService patService;

	@GetMapping("/participants")
	public List<Participant> getParticipant() {

		List<Participant> participants = patService.selectAll();

		return participants;
	}

	@PostMapping("/participants")
	public void add(@RequestBody Participant p) {

		patService.add(p);

	}

	@GetMapping("/participants/{id}")
	public Participant selectById(@PathVariable("id") int id) {
		Participant p = patService.selectById(id);
		return p;

	}

	@DeleteMapping("/participants/{id}")
	public void delete(@PathVariable("id") int id) {
		patService.delete(id);
	}

	@GetMapping("/participantsparformation/{id}")
	public List<Participant> chercherparformation(@PathVariable("id") int id){
		
	
	 List<Participant> participants = patService.chercherParFormationId(id); 
	 
	 return participants; }
}
