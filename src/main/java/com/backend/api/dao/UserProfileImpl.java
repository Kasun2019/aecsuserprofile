package com.backend.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.api.model.UserProfile;

@Repository
public class UserProfileImpl implements UserProfileDao {

	@Autowired
	private EntityManager entitymanager;
	
	@Override
	public List<UserProfile> get() {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<UserProfile> query=currentSession.createQuery("from UserProfile",UserProfile.class);
		List<UserProfile> list=query.getResultList();
		
		return list;
	}

	@Override
	public UserProfile get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserProfile userProfile) {
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.save(userProfile);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
