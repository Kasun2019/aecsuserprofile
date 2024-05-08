package com.backend.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.api.dao.UserProfileDao;
import com.backend.api.model.UserProfile;


@RestController
public class UserProfileController {

	
	@Autowired
	private UserProfileDao userProfileDao;
	
	
	@GetMapping("/profileSetup")
	public String profileSetup() {
		
		return "setup success";
	}
	@GetMapping("/details")
	public List<UserProfile> getProfileDetails() {
		
		return userProfileDao.get();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/putDetails")
	public ResponseEntity<Map<String,Object>> putProfileDetails(@RequestBody UserProfile userProfile) {
		Map<String, Object> response=new HashMap<>();
		try {
			userProfileDao.save(userProfile);
		
			response.put("status", "200");
			response.put("message", "Record save success !");
			response.put("data", userProfile);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "500");
			response.put("message", "Error Report !");
			response.put("data", e);
		}
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
}
