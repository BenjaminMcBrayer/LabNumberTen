//Benjamin McBrayer, 5.6.2018

package com.movies.gc;

public class Movie {
	private String movie;
	private String category;

	public Movie(String movie, String category) {
		super();
		this.movie = movie;
		this.category = category;
	}

	public String getMovie() {
		return movie;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return movie + " " + category;
	}
}