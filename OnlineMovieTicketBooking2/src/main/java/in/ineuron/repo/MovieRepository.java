package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Admin;
import in.ineuron.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findByMovieNameContaining(String name);
	
	Movie findByMovieName(String movieName);

}
