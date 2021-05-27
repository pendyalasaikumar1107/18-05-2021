package com.tcs.profile_evaluation.controller;

import java.util.List;

import javax.validation.Valid;

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
	public String putEvaluator(@Valid @RequestBody EvaluatorAssignedPo eval) {
		
		return leadService.updateEvaluator(eval);
		
	}
	
//	get daily hired and not hired array
	@GetMapping("/date/{date}")
	public int[] profileWithDate(@PathVariable String date){
		int[] dateFilter= new int[9];
		int hired=0; int nothired=0; 
		int junior=0;int gap=0;int skill=0;int notavailable=0;int notjoin=0;
		List<Integer> list= repo.findByDate(date);
		dateFilter[0]=list.size();
		List<Profilestatus> listStatus= checkStatus.findAllById(list);
		for (Profilestatus profilestatus : listStatus) {
			if(profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if(profilestatus.getStatus().equalsIgnoreCase("not hired"))
			{
				nothired++;
				if(profilestatus.getComments().equalsIgnoreCase("Too junior"))
				{
					junior++;
				}
					if(profilestatus.getComments().equalsIgnoreCase("Competency Gap"))
					{
						gap++;
	
					}
						if(profilestatus.getComments().equalsIgnoreCase("Skills Mismatched")) {
							skill++;
						}
							if(profilestatus.getComments().equalsIgnoreCase("Not Available")) {
								notavailable++;
							}
								if(profilestatus.getComments().equalsIgnoreCase("Associate not willing to join")) {
									notjoin++;
								}
			}
		}
		dateFilter[1] = hired;
		dateFilter[2] = nothired;
		dateFilter[3] =dateFilter[0]-dateFilter[1]-dateFilter[2];
		dateFilter[4]=junior;
		dateFilter[5]=gap;
		dateFilter[6]=skill;
		dateFilter[7]=notavailable;
		dateFilter[8]=notjoin;
		return dateFilter;
	}
	
//	get monthly hired and not hired array
	@GetMapping("/month/{month}")
	public int[] profileWithMonth(@PathVariable String month){
		int[] monthFilter= new int[9];
		int hired=0; int nothired=0;
		int junior=0;int gap=0;int skill=0;int notavailable=0;int notjoin=0;
		List<Integer> list= repo.findByMonth(month);
		monthFilter[0]=list.size();
		List<Profilestatus> listStatus=checkStatus.findAllById(list);
		for (Profilestatus profilestatus : listStatus) {
			if(profilestatus.getStatus().equalsIgnoreCase("hired"))
				hired++;
			if(profilestatus.getStatus().equalsIgnoreCase("not hired"))
			{
					nothired++;
					if(profilestatus.getComments().equalsIgnoreCase("Too Junior"))
					{
						junior++;
					}
						if(profilestatus.getComments().equalsIgnoreCase("Competency Gap"))
						{
							gap++;
		
						}
							if(profilestatus.getComments().equalsIgnoreCase("Skills Mismatched")) {
								skill++;
							}
								if(profilestatus.getComments().equalsIgnoreCase("Not Available")) {
									notavailable++;
								}
									if(profilestatus.getComments().equalsIgnoreCase("Associate not willing to join")) {
										notjoin++;
									}
			}
		}
		monthFilter[1]=hired;
		monthFilter[2]=nothired;
		monthFilter[3]=monthFilter[0]-monthFilter[1]-monthFilter[2];
		monthFilter[4]=junior;
		monthFilter[5]=gap;
		monthFilter[6]=skill;
		monthFilter[7]=notavailable;
		monthFilter[8]=notjoin;
		return monthFilter;
	
	}
	
//send all the profiles of respective month
	@GetMapping("/monthprofiles/{month}")
	public List<Integer> profileByWithMonth(@PathVariable String month){
		return  repo.findByMonth(month);
	}
	
	//get all profiles with status and evaluator assigned
	@GetMapping("/updated")
    public List<Profile> getDbdetails() {
		List <Profile> values = repo.findAll();
		System.out.println(values);
		return values;
		

	}
}
	
	
	
