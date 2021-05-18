package com.tcs.evaluation.profileEvaluation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.evaluation.profileEvaluation.Entity.Profile;
//import com.tcs.evaluation.profileEvaluation.Repository.ProfileRepo;
import com.tcs.evaluation.profileEvaluation.Services.ProfileService;

@CrossOrigin
@RestController
public class RmgProfileController {
	@Autowired
	ProfileService service;
	
	@PostMapping("/addProfile")
	public String addProfile(@RequestBody Profile profile) {
		return service.addProfile(profile);
	}
}
