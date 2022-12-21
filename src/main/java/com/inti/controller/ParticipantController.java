package com.inti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Formation;
import com.inti.model.Participant;
import com.inti.model.Payement;
import com.inti.model.Transaction;
import com.inti.service.IDiplomeService;
import com.inti.service.IFormationService;
import com.inti.service.IParticipantService;
import com.inti.service.IPayementService;



@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ParticipantController {

	@Autowired
	IParticipantService patService;
	
	@Autowired
	IFormationService formServ;
	
	@Autowired
	IDiplomeService diplServ;
	
	@Autowired
	IPayementService payementService;

	@GetMapping("/participants")
	public List<Participant> getParticipant() {

		List<Participant> participants = patService.selectAll();

		return participants;
	}

	@PostMapping("/participants")
	public void add(@RequestBody Participant p) {
		
				//recuperation formation et diplome du participant
				Set<Formation> setFrom = formServ.getByidParticipants(p.getId());
				List<Formation> listform = new ArrayList<Formation>(setFrom);
				p.setFormations(listform);
				p.setDiplomes(diplServ.selectAllByIdPart(p.getId()));
		
				//si pas encore de transaction 
				if(p.getTransactions()==null) {
					System.out.println("pas de transactions");
					patService.add(p);
					}
				//si transaction
				else {					
					//si pas de payement (ou total = 0)
					System.out.println("presence transaction transactions" + p.getTransactions().get(0).getPayement().getId());
					if(p.getTransactions().get(0).getPayement().getId()==0) {
						System.out.println("pas encore de payement");
					float total = 0;					
					List<Transaction> newlistetrans = p.getTransactions();
					//test ajout participant dans transactions
						for(Transaction trans : newlistetrans) {
							trans.setParticipant(p);
						}
										
						//si formations 
						if(!p.getFormations().isEmpty()) {
							System.out.println(p.getFormations().size());
							for(Formation form : p.getFormations()) {
								total = total + form.getPrix();				
							}	
						}
					
					float paye = 0;
					//prix total payé						
						for(Transaction trans : p.getTransactions()) {
							paye = paye + trans.getMontant();				
						}	
					
						p.getTransactions().get(0).getPayement().setPaye(paye);
						p.getTransactions().get(0).getPayement().setTotal(total);
						
				
					}
					
				//si deja payement (total != 0)
				if(p.getTransactions().get(0).getPayement().getId()!=0) {
					System.out.println("deja de payement");								
					float total = 0;					
					List<Transaction> newlistetrans = p.getTransactions();
					//test ajout participant dans transactions
					for(Transaction trans : newlistetrans) {
						trans.setParticipant(p);
					}
					
					//recalcul cout formation si ajout/supression formation entre temps 
					if(!p.getFormations().isEmpty()) {
						for(Formation form : p.getFormations()) {
							total = total + form.getPrix();				
						}	
					}
					
					float paye = 0;
					//prix total payé						
						for(Transaction trans : p.getTransactions()) {
							paye = paye + trans.getMontant();	
							//injection du premier payement de la liste dans tous les transaction 
							trans.setPayement(p.getTransactions().get(0).getPayement());
						}	
						
						p.getTransactions().get(0).getPayement().setPaye(paye);
						p.getTransactions().get(0).getPayement().setTotal(total);
					}	

				patService.add(p);
				}
	}
	
	@PutMapping("/modifparticipants")
	public void mod(@RequestBody Participant p) {

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
