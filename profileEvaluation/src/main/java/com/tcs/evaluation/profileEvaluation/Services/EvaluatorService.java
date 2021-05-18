package com.tcs.evaluation.profileEvaluation.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.evaluation.profileEvaluation.Entity.Evaluator;
import com.tcs.evaluation.profileEvaluation.Entity.Evaluatorassigned;
import com.tcs.evaluation.profileEvaluation.Entity.Profile;
import com.tcs.evaluation.profileEvaluation.Repository.EvaluatorRepo;
import com.tcs.evaluation.profileEvaluation.Repository.Evaluator_Assigned;
import com.tcs.evaluation.profileEvaluation.Repository.ProfileRepo;

@Service
public class EvaluatorService {
	
	@Autowired
	EvaluatorRepo erepo;
	public List<Evaluator> getAllEvaluators(){
		return erepo.findAll();
	}
	
	Evaluator_Assigned evalAssigned;
	@Autowired
	ProfileRepo repo1;
//	public List<Profile> assignedProfilesByEvaluatorId( int id) {
//			List<Long> myList1 = new ArrayList<Long>();
//			List<Evaluatorassigned> myList = new ArrayList<Evaluatorassigned>();
//			myList = evalAssigned.findByevalid(id);
//			for (int i = 0; i < myList.size(); i++) {
//				// if(myList.get(i).getId()==id)
//				myList1.add(myList.get(i).getId());
//			}
//			return repo1.findAllById(myList1);
//
//		}
//		List<Long> myList1 = new ArrayList<Long>();
//		List<Evaluatorassigned> myList = new ArrayList<Evaluatorassigned>();
//		myList = evalAssigned.findByevalid(id);
//		for (int i = 0; i < myList.size(); i++) {
//			// if(myList.get(i).getId()==id)
//			myList1.add(myList.get(i).getId());
//		}
//		return repo1.findAllById(myList1);
//
//	}
}
