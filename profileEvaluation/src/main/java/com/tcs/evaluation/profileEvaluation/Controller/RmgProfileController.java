package com.tcs.evaluation.profileEvaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.evaluation.profileEvaluation.po.Profilepo;
import com.tcs.evaluation.profileEvaluation.services.ProfileService;

@CrossOrigin
@RestController
public class RmgProfileController {
	@Autowired
	ProfileService service;
	
	@PostMapping("/addProfile")
	public String addProfile(@RequestBody Profilepo profilepo) {
		return service.addProfile(profilepo);
	}
}
