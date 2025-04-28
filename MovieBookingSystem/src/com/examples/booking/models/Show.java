package com.examples.booking.models;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Show {
	String id;
	Movie movie;
	Date startTime;
	Screen screen;
	public Show(String id, Movie movie, Date startTime, Screen screen) {
		super();
		this.id = id;
		this.movie = movie;
		this.startTime = startTime;
		this.screen = screen;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public List<Seat> getSeats(){
		return this.getScreen().getSeats();
	}
	@Override
	public String toString() {
		return "Show [id=" + id + ", movie=" + movie + ", startTime=" + startTime + ", screen=" + screen + "]";
	}
	
}
