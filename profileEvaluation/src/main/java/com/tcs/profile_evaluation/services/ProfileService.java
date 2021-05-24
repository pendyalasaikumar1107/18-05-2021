package com.tcs.profile_evaluation.services;


import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.profile_evaluation.entity.Profile;
import com.tcs.profile_evaluation.po.Profilepo;
import com.tcs.profile_evaluation.repository.ProfileRepo;


@Service
public class ProfileService {
	@Autowired
	ProfileRepo repo;
		
		
	public String addProfile(Profilepo profilepo){
		Profile profile = new Profile();
		profile.setId(profilepo.getId());
		profile.setName(profilepo.getName());
		profile.setExperience(profilepo.getExperience());
		profile.setLocation(profilepo.getLocation());
		profile.setMobileno(profilepo.getMobileno());
		profile.setSkill1(profilepo.getSkill1());
		profile.setSkill2(profilepo.getSkill2());
		profile.setVendor(profilepo.getVendor());
		profile.setDate(java.time.LocalDate.now());
	

		
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

