package com.tcs.evaluation.profileEvaluation.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.evaluation.profileEvaluation.Entity.Evaluatorassigned;
import com.tcs.evaluation.profileEvaluation.Entity.Profile;
import com.tcs.evaluation.profileEvaluation.Repository.Evaluator_Assigned;
import com.tcs.evaluation.profileEvaluation.Repository.ProfileRepo;
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
	public String updateEvaluator(Evaluatorassigned eval) {
		evaluator.save(eval);
		return "Evaluator Assigned";
	}
	
}
