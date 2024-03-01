package in.ineuron.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ineuron.model.Casting;
import in.ineuron.model.Movie;
import in.ineuron.model.MovieCasting;
import in.ineuron.repo.MovieCastingRepository;
import in.ineuron.service.IMovieCastingService;

@Service
public class MovieCastingServiceImpl implements IMovieCastingService {
	
	@Autowired
	private MovieCastingRepository repo;

	@Override
	@Transactional
	public String saveMovieCasting(MovieCasting movieCasting) {
		MovieCasting moviecasting = repo.save(movieCasting);
		if(moviecasting==null) {
			return "MovieCasting did not saved";
		}
		return "Movie casting saved properly with the id "+moviecasting.getMovieCastingId();
	}

	@Override
	public List<Casting> findCastingByMovieId(Integer movieId) {
		return repo.findCastingsByMovieId(movieId);
	}

	@Override
	public List<Integer> findCastingIdsByMovieId(Integer movieId) {
		return repo.findCastingIdsByMovieId(movieId);
	}

	@Override
	public List<MovieCasting> findMovieCastingBymovie(Movie movie) {
		return repo.findMovieCastingsByMovie(movie);
	}

	@Override
	public String deleteMovieCastingsByMovieCasting(List<MovieCasting> movieCastings) {
		try {
            repo.deleteAllInBatch(movieCastings);
            return "success";
        } catch (Exception e) {
            return "Error deleting MovieCasting entities: " + e.getMessage();
        }
	}

}
