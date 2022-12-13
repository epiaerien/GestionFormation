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

import com.inti.model.Commercial;
import com.inti.service.ICommercialService;



@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CommercialController {
	
	@Autowired
	ICommercialService comService;

	@GetMapping("/commercials")
	public List<Commercial> getCommercial() {

		List<Commercial> commercials = comService.selectAll();

		return commercials;
	}

	@PostMapping("/commercials")
	public void add(@RequestBody Commercial c) {

		comService.add(c);

	}

	@GetMapping("/commercials/{id}")
	public Commercial selectById(@PathVariable("id") int id) {
		Commercial c = comService.selectById(id);
		return c;

	}

	@DeleteMapping("/commercials/{id}")
	public void delete(@PathVariable("id") int id) {
		comService.delete(id);
	}

}
