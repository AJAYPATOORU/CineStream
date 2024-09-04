package com.kodnest.cinestream.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.cinestream.entities.Movie;
import com.kodnest.cinestream.entities.User;
import com.kodnest.cinestream.repositories.UserRepository;
import com.kodnest.cinestream.services.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository usrepo;

	@Override
	public String addUsers(User usr) {
		usrepo.save(usr);
		return "User is created";
	}

	@Override
	public boolean emailExists(String email) {
		if (usrepo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkUser(String email, String password) {
		User usr = usrepo.findByEmail(email);
		String db_password = usr.getPassword();
		if (db_password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> viewUser(String email) {
//		List<User> userlist=usrepo.findAll();
		List<User> userlist = usrepo.findByEmailNot(email);
		return userlist;
	}

	@Override
	public String deleteUser(int id) {
		usrepo.deleteById(id);
		return "user deleted";
	}

	@Override
	public User getUser(String email) {
		User usr = usrepo.findByEmail(email);
		return usr;
	}

	@Override
	public User getUser(int id) {
		User usr = usrepo.getById(id);
		return usr;
	}

	@Override
	public void updateUser(User usr) {
		usrepo.save(usr);
	}

	@Override
	public Movie getMovieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
