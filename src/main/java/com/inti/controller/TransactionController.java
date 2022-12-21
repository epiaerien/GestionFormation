package com.inti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.inti.model.Formation;
import com.inti.model.Payement;
import com.inti.model.Transaction;

import com.inti.service.IFormationService;
import com.inti.service.ITransactionService;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class TransactionController {
	
	@Autowired
	ITransactionService transService;
	
	@Autowired
	IFormationService formServ;

	@GetMapping("/transactions")
	public List<Transaction> getTransactions() {

		List<Transaction> transactions = transService.selectAll();

		return transactions;
	}

	@PostMapping("/transactions")
	public void add(@RequestBody Transaction t) {
		/*
		//pas besoin asse tout par participant
		//si pas encore de payement 
		if(t.getPayement()==null) {
			float total = 0;
			
			List<Transaction> newlistetrans = new ArrayList<>();
			newlistetrans.add(t);
			
			Set<Formation> listefrom = formServ.getByidParticipants(t.getParticipant().getId());
			for(Formation form : listefrom) {
				total = total + form.getPrix();				
			}			
			Payement payement = new Payement();
			payement.setPaye(t.getMontant());
			payement.setTotal(total);
			payement.setTransactions(newlistetrans);
			t.setPayement(payement);
			}
		//si deja payement
		if(t.getPayement()!=null) {
						
			List<Transaction> newlistetrans = t.getParticipant().getTransactions();
			newlistetrans.add(t);
			
			float paye = t.getPayement().getPaye() + t.getMontant();
			
			t.getPayement().setPaye(paye);
			
			t.getPayement().setTransactions(newlistetrans);
			}		*/
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
	
	@GetMapping("/transbyPartId/{id}")
	public List<Transaction> getAllByPartId(@PathVariable("id") int idPArt) {

		List<Transaction> trans = transService.selectAllByIdPart(idPArt);
		return trans;

	}

}
