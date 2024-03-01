package in.ineuron.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Movie;
import in.ineuron.repo.MovieRepository;
import in.ineuron.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private MovieRepository repo;
	
	@Override
	@Transactional
	public Movie saveMovie(Movie movie) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		movie.setCreatedDate(sqlDate);
		Movie m = repo.save(movie);
		return m;
	}

	@Override
	public List<Movie> searchMovie(String movie) {
		return repo.findByMovieNameContaining(movie);
	}

	@Override
	public Movie findMovie(String movie) {
		return repo.findByMovieName(movie);
	}

	@Override
	public String deleteMovieByMovie(Movie movie) {
		try {
            repo.delete(movie);
            return "success";
        } catch (Exception e) {
            return "Error deleting MovieCasting entities: " + e.getMessage();
        }
	}

	

}
