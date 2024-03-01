package in.ineuron.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Movie;
import in.ineuron.model.MovieUpdate;
import in.ineuron.repo.MovieUpdateRepository;
import in.ineuron.service.IMovieUpdateService;

@Service
public class MovieUpdateServiceImpl implements IMovieUpdateService {
	
	@Autowired
	MovieUpdateRepository repo;

	@Override
	public MovieUpdate saveMovieUpdate(MovieUpdate movieUpdate) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		movieUpdate.setModificationTime(sqlDate);
		return repo.save(movieUpdate);
	}

	@Override
	public List<MovieUpdate> getMovieUpdateListByMovie(Movie movie) {
		return repo.findByMovie(movie);
	}

	@Override
	public String deleteMovieUpdateListByMovie(List<MovieUpdate> movieUpdateList) {
		try {
            repo.deleteAllInBatch(movieUpdateList);
            return "success";
        } catch (Exception e) {
            return "Error deleting MovieCasting entities: " + e.getMessage();
        }
	}

}
    