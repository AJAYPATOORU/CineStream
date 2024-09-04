package com.kodnest.cinestream.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.cinestream.entities.Movie;
import com.kodnest.cinestream.repositories.MovieRepository;
import com.kodnest.cinestream.services.MovieService;

@Service
public class MovieServiceImplementation implements MovieService {
	@Autowired
	MovieRepository movieRepository;

	@Override
	public String addMovie(Movie mov) {
		movieRepository.save(mov);
		return "Movie is Added";
	}

	@Override
	public List<Movie> viewMovie() {
		List<Movie> movieList = movieRepository.findAll();
		return movieList;
	}

	@Override
	public String deleteMovie(int id) {
		movieRepository.deleteById(id);
		return "Movie Deleted";
	}

	@Override
	public Movie viewMovie(int id) {
		Movie movie = movieRepository.getById(id);
		return movie;
	}

	public List<Movie> getLast5Products() {
		return movieRepository.findTop5ByOrderByCreatedAtDesc();
	}
}
