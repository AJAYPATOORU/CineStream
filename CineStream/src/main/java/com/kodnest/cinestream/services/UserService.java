package com.kodnest.cinestream.services;

import java.util.List;

import com.kodnest.cinestream.entities.Movie;
import com.kodnest.cinestream.entities.User;

public interface UserService {
	public String addUsers(User usr);

	public boolean emailExists(String email);

	public boolean checkUser(String email, String password);

	public List<User> viewUser(String email);

	public String deleteUser(int id);

	public User getUser(String email);

	public User getUser(int id);

	public void updateUser(User usr);

	public Movie getMovieById(Long id);
}
