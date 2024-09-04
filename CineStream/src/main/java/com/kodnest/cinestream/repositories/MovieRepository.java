package com.kodnest.cinestream.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.cinestream.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findTop5ByOrderByCreatedAtDesc();
}
