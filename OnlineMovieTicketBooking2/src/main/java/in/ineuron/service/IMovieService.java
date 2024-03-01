package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Movie;

public interface IMovieService {
	
	public Movie saveMovie(Movie movie);
	
	public List<Movie> searchMovie(String movie);
	
	public Movie findMovie(String movie);
	
	public String deleteMovieByMovie(Movie movie);

}
