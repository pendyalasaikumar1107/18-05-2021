package com.tcs.profile_evaluation.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profile_evaluation.entity.Evaluator;
import com.tcs.profile_evaluation.repository.EvaluatorRepo;
import com.tcs.profile_evaluation.repository.Evaluator_Assigned;
import com.tcs.profile_evaluation.repository.ProfileRepo;

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
