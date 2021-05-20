package com.tcs.evaluation.profileEvaluation.services;


import java.util.Random;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.evaluation.profileEvaluation.entity.Profile;
import com.tcs.evaluation.profileEvaluation.po.Profilepo;
import com.tcs.evaluation.profileEvaluation.repository.ProfileRepo;


@Service
public class ProfileService {
	@Autowired
	ProfileRepo repo;
//	Profile profile;
		
		LocalDate date = new LocalDate();
	public String addProfile(Profilepo profilepo){
		Profile profile = new Profile();
		System.out.println(profilepo);
		System.out.println("profile "+profile);
		profile.setId(profilepo.getId());
		profile.setName(profilepo.getName());
		profile.setExperience(profilepo.getExperience());
		profile.setLocation(profilepo.getLocation());
		profile.setMobileno(profilepo.getMobileno());
		profile.setSkill1(profilepo.getSkill1());
		profile.setSkill2(profilepo.getSkill2());
		profile.setVendor(profilepo.getVendor());
		
		profile.setDate(date.toString());
		
//		System.out.println(profile.getDate());
		
//		LocalDate date1 = new LocalDate(profile.getDate());
		
//		System.out.println(date1.getMonthOfYear());
//		System.out.println(date1.getWeekOfWeekyear());
		
		if (profile.getId() ==  0) {
			Random rnd = new Random();
		    int number = rnd.nextInt(999999);
			profile.setId(number);
		}

		if(repo.existsById(profile.getId())) {
			return "Sorry";
		}
		else {
			repo.save(profile);
			return "success";
		}
	}

}

