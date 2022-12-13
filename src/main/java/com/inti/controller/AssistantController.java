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

import com.inti.model.Assistant;
import com.inti.service.IAssistantService;


@Controller
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AssistantController {

	@Autowired
	IAssistantService assistantService;

	@GetMapping("/assistants")
	public List<Assistant> getAssistants() {

		List<Assistant> assistants = assistantService.selectAll();

		return assistants;
	}

	@PostMapping("/assistants")
	public void add(@RequestBody Assistant ass) {

		assistantService.add(ass);

	}

	@GetMapping("/assistants/{id}")
	public Assistant selectById(@PathVariable("id") int id) {
		Assistant ass = assistantService.selectById(id);
		return ass;

	}

	@DeleteMapping("/assistants/{id}")
	public void delete(@PathVariable("id") int id) {
		assistantService.delete(id);
	}

}
