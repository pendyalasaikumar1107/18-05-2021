package com.tcs.evaluation.profileEvaluation.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tcs.evaluation.profileEvaluation.entity.Evaluatorassigned;
import com.tcs.evaluation.profileEvaluation.entity.Profile;
import com.tcs.evaluation.profileEvaluation.entity.Profilestatus;
import com.tcs.evaluation.profileEvaluation.entity.updatedProfileDetails;
import com.tcs.evaluation.profileEvaluation.repository.Evaluator_Assigned;
import com.tcs.evaluation.profileEvaluation.repository.ProfileRepo;
import com.tcs.evaluation.profileEvaluation.repository.StatusRepo;
import com.tcs.evaluation.profileEvaluation.services.LeadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Repository
public class LeadController {
	
	@Autowired
	ProfileRepo repo;
	@Autowired
	LeadService service;
	@Autowired
	Evaluator_Assigned evalRepo;
	@Autowired
	StatusRepo checkStatus;
	
	@GetMapping("/getProfiles")
	public List<Profile> getData() {
		return service.getAllProfile();
	}
	
	@PutMapping("/updateProfile")
	public String putEvaluator(@RequestBody Evaluatorassigned eval) {
		
		return service.updateEvaluator(eval);
		
	}
	
	@GetMapping("/date/{date}")
	public int[] profileWithDate(@PathVariable String date){
		int[] dateFilter= new int[3];
		int hired=0; int nothired=0; int waiting=0;
		List<Integer> list= repo.findByDate(date);
		dateFilter[0]=list.size();
		List<Profilestatus> listStatus= checkStatus.findAllById(list);
		for (Profilestatus profilestatus : listStatus) {
			if(profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if(profilestatus.getStatus().equalsIgnoreCase("not hired"))
				nothired++;
		}
		dateFilter[1] = hired;
		dateFilter[2] = nothired;
		return dateFilter;
	}
	
	
	@GetMapping("/month/{month}")
	public int[] profileWithMonth(@PathVariable String month){
		int[] monthFilter= new int[4];
		int hired=0; int nothired=0; 
		List<Integer> list= repo.findByMonth(month);
		monthFilter[0]=list.size();
		List<Profilestatus> listStatus=checkStatus.findAllById(list);
		for (Profilestatus profilestatus : listStatus) {
			if(profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if(profilestatus.getStatus().equalsIgnoreCase("not hired"))
				nothired++;
				}
		monthFilter[1]=hired;
		monthFilter[2]=nothired;
		monthFilter[3]=monthFilter[0]-monthFilter[1]-monthFilter[2];
		return monthFilter;
	
	}
	
	@GetMapping("/monthprofiles/{month}")
	public List<Integer> profileByWithMonth(@PathVariable String month){
		return  repo.findByMonth(month);
	}
	
	@GetMapping("/updated")
    public List<Profile> getDbdetails() {
		List <Profile> values = repo.findAll();
		System.out.println(values);
		return values;
		

	}
}
	
	
	
