package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Owner;


public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	
	public Owner findByEmailId(String emailId);

}
