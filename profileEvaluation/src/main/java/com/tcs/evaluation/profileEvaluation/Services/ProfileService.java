package com.tcs.evaluation.profileEvaluation.Services;
import java.util.Random;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.evaluation.profileEvaluation.Entity.Profile;
import com.tcs.evaluation.profileEvaluation.Repository.ProfileRepo;


@Service
public class ProfileService {
	@Autowired
	ProfileRepo repo;

		LocalDate date = new LocalDate();
	public String addProfile(Profile profile){
		profile.setDate(date.toString());
		if (profile.getId() ==  0) {
			Random rnd = new Random();
		    int number = rnd.nextInt(999999);
			profile.setId(number);
		}
//		System.out.println(profile);
		if(repo.existsById(profile.getId())) {
			return "Sorry";
		}
		else {
			repo.save(profile);
			return "success";
		}
	}
//	public Profile getProfile() {
//		repo.findById();
//	}
}
