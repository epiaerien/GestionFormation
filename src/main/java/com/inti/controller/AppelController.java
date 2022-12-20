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

import com.inti.model.Appel;
import com.inti.model.Formation;
import com.inti.service.IAppelService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AppelController {

	@Autowired
	IAppelService apService;

	@GetMapping("/appels")
	public List<Appel> getappels() {

		List<Appel> appels = apService.selectAll();

		return appels;
	}

	@PostMapping("/appels")
	public void add(@RequestBody Appel u) {

		apService.add(u);

	}

	@GetMapping("/appels/{id}")
	public Appel selectById(@PathVariable("id") int id) {
		Appel u = apService.selectById(id);
		return u;

	}

	@DeleteMapping("/appels/{id}")
	public void delete(@PathVariable("id") int id) {
		apService.delete(id);
	}
	
	@GetMapping("/appelparcommercial/{id}")
	public List<Appel> appelparcommercial(@PathVariable("id") int id )
	{
		List<Appel> appels = apService.getbyidcommercial(id);
		return appels; 
	}

}
