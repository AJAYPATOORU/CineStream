package com.kodnest.cinestream.services;

import java.util.List;

import com.kodnest.cinestream.entities.Movie;

public interface MovieService {
	public String addMovie(Movie mov);

	public List<Movie> viewMovie();

	public String deleteMovie(int id);

	public Movie viewMovie(int id);

	public List<Movie> getLast5Products();
}
