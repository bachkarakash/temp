package com.signup.dao;

import java.util.List;

import com.signup.model.User;


public interface InfUser 
{
	Boolean  saveUser(User user);
	List<User> viewUser();

}
