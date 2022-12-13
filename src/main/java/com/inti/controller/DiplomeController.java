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

import com.inti.model.Diplome;
import com.inti.service.IDiplomeService;
import com.inti.service.IDiplomeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class DiplomeController {

	@Autowired
	IDiplomeService dipService;

	@GetMapping("/diplomes")
	public List<Diplome> getDiplomes() {

		List<Diplome> diplomes = dipService.selectAll();

		return diplomes;
	}

	@PostMapping("/diplomes")
	public void add(@RequestBody Diplome u) {

		dipService.add(u);

	}

	@GetMapping("/diplomes/{id}")
	public Diplome selectById(@PathVariable("id") int id) {

		Diplome u = dipService.selectById(id);
		return u;

	}

	@DeleteMapping("/diplomes/{id}")
	public void delete(@PathVariable("id") int id) {
		dipService.delete(id);
	}

}
