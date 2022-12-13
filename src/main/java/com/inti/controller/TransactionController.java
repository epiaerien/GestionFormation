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

import com.inti.model.Transaction;
import com.inti.service.ITransactionService;
import com.inti.service.ITransactionService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class TransactionController {
	
	@Autowired
	ITransactionService transService;

	@GetMapping("/transactions")
	public List<Transaction> getTransactions() {

		List<Transaction> transactions = transService.selectAll();

		return transactions;
	}

	@PostMapping("/transactions")
	public void add(@RequestBody Transaction t) {

		transService.add(t);

	}

	@GetMapping("/transactions/{id}")
	public Transaction selectById(@PathVariable("id") int id) {

		Transaction t = transService.selectById(id);
		return t;

	}

	@DeleteMapping("/transactions/{id}")
	public void delete(@PathVariable("id") int id) {
		transService.delete(id);
	}

}
