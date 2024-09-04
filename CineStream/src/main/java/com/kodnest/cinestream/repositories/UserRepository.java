package com.kodnest.cinestream.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.cinestream.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	// method to find User by using the email
	public User findByEmail(String email);

	//
	List<User> findByEmailNot(String email);
}
