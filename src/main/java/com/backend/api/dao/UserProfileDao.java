package com.backend.api.dao;

import java.util.List;

import com.backend.api.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> get();
	
	UserProfile get(int id);
	
	void save(UserProfile userProfile);
	
	void delete(int id);
}
