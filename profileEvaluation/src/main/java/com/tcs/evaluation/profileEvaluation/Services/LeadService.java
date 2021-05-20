package com.tcs.evaluation.profileEvaluation.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.evaluation.profileEvaluation.entity.Evaluatorassigned;
import com.tcs.evaluation.profileEvaluation.entity.Profile;
import com.tcs.evaluation.profileEvaluation.repository.Evaluator_Assigned;
import com.tcs.evaluation.profileEvaluation.repository.ProfileRepo;
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
