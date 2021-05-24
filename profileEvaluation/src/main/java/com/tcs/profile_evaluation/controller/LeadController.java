package com.tcs.profile_evaluation.controller;

import java.util.List;

import com.tcs.profile_evaluation.entity.Profile;
import com.tcs.profile_evaluation.entity.Profilestatus;
import com.tcs.profile_evaluation.po.EvaluatorAssignedPo;
import com.tcs.profile_evaluation.repository.Evaluator_Assigned;
import com.tcs.profile_evaluation.repository.ProfileRepo;
import com.tcs.profile_evaluation.repository.StatusRepo;
import com.tcs.profile_evaluation.services.LeadService;

import org.springframework.beans.factory.annotation.Autowired;
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
	LeadService leadService;
	@Autowired
	Evaluator_Assigned evalRepo;
	@Autowired
	StatusRepo checkStatus;
	
	@GetMapping("/getProfiles")
	public List<Profile> getData() {
		return leadService.getAllProfile();
	}
	
	@PutMapping("/updateProfile")
	public String putEvaluator(@RequestBody EvaluatorAssignedPo eval) {
		
		return leadService.updateEvaluator(eval);
		
	}
	
	@GetMapping("/date/{date}")
	public int[] profileWithDate(@PathVariable String date){
		int[] dateFilter= new int[3];
		int hired=0; int nothired=0; 
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
	
	
	
