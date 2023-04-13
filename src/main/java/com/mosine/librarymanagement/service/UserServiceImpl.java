package com.mosine.librarymanagement.service;

import java.util.List;

import com.mosine.librarymanagement.dao.UserDao;
import com.mosine.librarymanagement.dao.UserDaoImpl;
import com.mosine.librarymanagement.entities.User;


public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();

	@Override
	public void createUser(User u) {
		User ajoutUser = dao.create(u);
		if (ajoutUser != null)
			System.out.println("User : " + ajoutUser.getId() + " est ajouté!");
	}

	@Override
	public List<User> getAllUser() {
		return dao.findAll();
	}

	@Override
	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	public void updateUser(User user) {
		User u = dao.update(user);
		if (u != null)
			System.out.println("L'user " + u.getId() + " est mis à jour!");
	}

	@Override
	public void deleteUser(int id) {
		User u = dao.delete(id);
		if (u != null)
			System.out.println("L'user " + u.getId() + " est supprimé!");
	}

	@Override
	public void login(User user) {
		User u = dao.login(user);
		if (u != null) {
			System.out.println("Authentication successful!");
		}
	}

	@Override
	public User findUserByLogin(String login) {
		User u = dao.findByLogin(login);
		if (u == null)
			System.out.println("Error finding the user with specified login!");
		return u;
	}

}
