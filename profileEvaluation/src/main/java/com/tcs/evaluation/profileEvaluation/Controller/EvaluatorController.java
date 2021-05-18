package com.tcs.evaluation.profileEvaluation.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.evaluation.profileEvaluation.Entity.Evaluator;
import com.tcs.evaluation.profileEvaluation.Entity.Evaluatorassigned;
import com.tcs.evaluation.profileEvaluation.Entity.Profile;
import com.tcs.evaluation.profileEvaluation.Entity.Profilestatus;
import com.tcs.evaluation.profileEvaluation.Repository.Evaluator_Assigned;
import com.tcs.evaluation.profileEvaluation.Repository.ProfileRepo;
import com.tcs.evaluation.profileEvaluation.Repository.StatusRepo;
import com.tcs.evaluation.profileEvaluation.Services.EvaluatorService;

@RestController
@CrossOrigin
public class EvaluatorController {
    @Autowired
    StatusRepo statusrepo;
	@Autowired
	Evaluator_Assigned evalAssigned;
	@Autowired
	ProfileRepo repo;
	@Autowired
	EvaluatorService eservice;
	

	@GetMapping("/evaluator/{id}")
	public List<Profile> getProfilesByEvaluatorId(@PathVariable int id) {
	//	return eservice.assignedProfilesByEvaluatorId(id);
		List<Integer> myList1 = new ArrayList<Integer>();
		List<Evaluatorassigned> myList = new ArrayList<Evaluatorassigned>();
		myList = evalAssigned.findByevalid(id);
		for (int i = 0; i < myList.size(); i++) {
			// if(myList.get(i).getId()==id)
			myList1.add(myList.get(i).getId());
		}
		return repo.findAllById(myList1);
	}

	@GetMapping("/getEvaluators")
	public List<Evaluator> getAllEvaluators() {
		return eservice.getAllEvaluators();
	}

	@GetMapping("/Assigned")
	public List<Evaluatorassigned> allAssigned(){
		return evalAssigned.findAll();
	}
	
	@GetMapping("getupdateprofile")
	public List<Profilestatus> sendupdatedStatus(){
		return statusrepo.findAll();
	}
	
	@PutMapping("/statusupdate")
	public String updateprofile(@RequestBody Profilestatus status) {
		statusrepo.save(status);
		evalAssigned.deleteById(status.getId());
	return "status updated"	;
	}
}
