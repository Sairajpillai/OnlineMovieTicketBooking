package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Admin;
import in.ineuron.model.Casting;

public interface CastingRepository extends JpaRepository<Casting, Integer> {

}
