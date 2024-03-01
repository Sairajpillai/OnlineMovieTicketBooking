package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Admin;
import in.ineuron.model.Movie;
import in.ineuron.model.MovieUpdate;
import java.util.List;


public interface MovieUpdateRepository extends JpaRepository<MovieUpdate, Integer> {
	
	public List<MovieUpdate> findByMovie(Movie movie);

}
