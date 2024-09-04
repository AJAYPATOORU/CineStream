package com.kodnest.cinestream.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String moviename;
	@Column(length = 2000)
	String movieLink;
	@Column(length = 2000)
	String imgLink;
	String year;
	String duration;
	String movieGenre;
	String movieCast;
	String movieDirector;
	Date createdAt;
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String moviename, String movieLink, String imgLink, String year, String duration,
			String movieGenre, String movieCast, String movieDirector, Date createdAt) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.movieLink = movieLink;
		this.imgLink = imgLink;
		this.year = year;
		this.duration = duration;
		this.movieGenre = movieGenre;
		this.movieCast = movieCast;
		this.movieDirector = movieDirector;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getMovieLink() {
		return movieLink;
	}

	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", moviename=" + moviename + ", movieLink=" + movieLink + ", imgLink=" + imgLink
				+ ", year=" + year + ", duration=" + duration + ", movieGenre=" + movieGenre + ", movieCast="
				+ movieCast + ", movieDirector=" + movieDirector + ", createdAt=" + createdAt + "]";
	}
}
