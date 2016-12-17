package com.dream.dao;

import java.util.List;

import com.dream.module.User;

public interface UserDAO {
	
public List<User> list();
	
	public User get(String id);
	
	public void saveOrUpdate(User user);
	
	
	public void delete(String id);

	public boolean isValidUser(String id, String password, boolean isAdmin);
}
