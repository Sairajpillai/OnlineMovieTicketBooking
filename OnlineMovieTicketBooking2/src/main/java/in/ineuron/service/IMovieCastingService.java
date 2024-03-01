package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Casting;
import in.ineuron.model.Movie;
import in.ineuron.model.MovieCasting;

public interface IMovieCastingService {
	
	public String saveMovieCasting(MovieCasting movieCasting);
	
	public List<Casting> findCastingByMovieId(Integer movieId);
	
	public List<Integer> findCastingIdsByMovieId(Integer movieId);
	
	public List<MovieCasting> findMovieCastingBymovie(Movie movie);
	
	public String deleteMovieCastingsByMovieCasting(List<MovieCasting> movieCasting);

}
