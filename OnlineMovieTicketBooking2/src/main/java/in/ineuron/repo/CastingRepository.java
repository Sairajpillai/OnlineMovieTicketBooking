package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ineuron.model.Casting;
import java.util.List;


public interface CastingRepository extends JpaRepository<Casting, Integer> {
	
	public List<Casting> findByActor(String actor);
	
	@Query("from Casting where actor=:actor")
	public Casting findByActorName(@Param("actor") String actor);

}
