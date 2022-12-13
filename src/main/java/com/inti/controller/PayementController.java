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

import com.inti.model.Payement;
import com.inti.service.IPayementService;
import com.inti.service.IPayementService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PayementController {
	
	@Autowired
	IPayementService payService;

	@GetMapping("/payements")
	public List<Payement> getPayements() {

		List<Payement> payements = payService.selectAll();

		return payements;
	}

	@PostMapping("/payements")
	public void add(@RequestBody Payement u) {

		payService.add(u);

	}

	@GetMapping("/payements/{id}")
	public Payement selectById(@PathVariable("id") int id) {

		Payement p = payService.selectById(id);
		return p;

	}

	@DeleteMapping("/payements/{id}")
	public void delete(@PathVariable("id") int id) {
		payService.delete(id);
	}

}
