package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Movie;
import in.ineuron.model.MovieUpdate;

public interface IMovieUpdateService {
	
	public MovieUpdate saveMovieUpdate(MovieUpdate movieUpdate);
	
	public List<MovieUpdate> getMovieUpdateListByMovie(Movie movie);
	
	public String deleteMovieUpdateListByMovie(List<MovieUpdate> movieUpdateList);

}
