package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ineuron.model.Casting;
import in.ineuron.model.MovieCasting;
import in.ineuron.model.Movie;


public interface MovieCastingRepository extends JpaRepository<MovieCasting, Integer> {
	
	@Query("SELECT mc.casting FROM MovieCasting mc WHERE mc.movie.movieId = :movieId")
    List<Casting> findCastingsByMovieId(@Param("movieId") Integer movieId);
	
	@Query("SELECT mc.casting.castingId FROM MovieCasting mc WHERE mc.movie.movieId = :movieId")
    List<Integer> findCastingIdsByMovieId(@Param("movieId") Integer movieId);
	
	List<MovieCasting> findMovieCastingsByMovie(Movie movie);

}
