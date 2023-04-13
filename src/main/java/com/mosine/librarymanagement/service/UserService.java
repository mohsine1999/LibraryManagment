package com.mosine.librarymanagement.service;

import java.util.List;

import com.mosine.librarymanagement.entities.User;


public interface UserService {

	void createUser(User u);

	List<User> getAllUser();

	User getUserById(int id);

	void updateUser(User user);

	void deleteUser(int id);
	
	void login(User user);
	
	User findUserByLogin(String login);

}
