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

import com.inti.model.Prospect;
import com.inti.service.IProspectService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProspectController {

	
	@Autowired
	IProspectService prService; 
	
	@GetMapping("/prospects")
	public List<Prospect> getprospects() {

		List<Prospect> prospects = prService.selectAll();

		return prospects;
	}

	@PostMapping("/prospects")
	public void add(@RequestBody Prospect u) {

		prService.add(u);

	}

	@GetMapping("/prospects/{id}")
	public Prospect selectById(@PathVariable("id") int id) {
		Prospect p = prService.selectById(id);
		return p;

	}

	@DeleteMapping("/prospects/{id}")
	public void delete(@PathVariable("id") int id) {
		prService.delete(id);
	}
}
