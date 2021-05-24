package com.tcs.profile_evaluation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.profile_evaluation.po.Profilepo;
import com.tcs.profile_evaluation.services.ProfileService;

@CrossOrigin
@RestController
public class RmgProfileController {
	
	
	@Autowired
	ProfileService profileService;
	
	@PostMapping("/addProfile")
	public String addProfile(@Valid @RequestBody Profilepo profilepo) {
		return profileService.addProfile(profilepo);
	}

	
}
