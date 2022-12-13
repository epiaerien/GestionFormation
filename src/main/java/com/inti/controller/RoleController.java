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

import com.inti.model.Role;
import com.inti.service.IRoleService;



@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RoleController {

	@Autowired
	IRoleService roService;

	@GetMapping("/roles")
	public List<Role> getRole() {

		List<Role> roles = roService.selectAll();

		return roles;
	}

	@PostMapping("/roles")
	public void add(@RequestBody Role r) {

		roService.add(r);

	}

	@GetMapping("/roles/{id}")
	public Role selectById(@PathVariable("id") int id) {
		Role r = roService.selectById(id);
		return r;

	}

	@DeleteMapping("/roles/{id}")
	public void delete(@PathVariable("id") int id) {
		roService.delete(id);
	}


}
