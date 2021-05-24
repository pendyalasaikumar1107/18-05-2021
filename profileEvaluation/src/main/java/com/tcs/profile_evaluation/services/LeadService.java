package com.tcs.profile_evaluation.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profile_evaluation.entity.Evaluatorassigned;
import com.tcs.profile_evaluation.entity.Profile;
import com.tcs.profile_evaluation.po.EvaluatorAssignedPo;
import com.tcs.profile_evaluation.repository.Evaluator_Assigned;
import com.tcs.profile_evaluation.repository.ProfileRepo;
@Service
public class LeadService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	ProfileRepo prepo;
	public List<Profile> getAllProfile(){
		return prepo.findAll();
	}
	
	@Autowired
	Evaluator_Assigned evaluator;
	public String updateEvaluator(EvaluatorAssignedPo eval) {
		Evaluatorassigned evaluatorAssigned= new Evaluatorassigned();
		evaluatorAssigned.setEvalname(eval.getEvalname());
		evaluatorAssigned.setEvalid(eval.getEvalid());
		evaluatorAssigned.setId(eval.getId());
		
		evaluator.save(evaluatorAssigned);
		return "Evaluator Assigned";
	}
	
}
