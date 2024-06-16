package in.ineuron.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Owner;
import in.ineuron.repo.OwnerRepository;
import in.ineuron.service.IOwnerService;

@Service
public class OwnerServiceImpl implements IOwnerService {
	
	@Autowired
	OwnerRepository repo;

	@Override
	public Owner saveOwner(Owner owner) {
		return repo.save(owner);
	}

	@Override
	public Owner findOwnerByemail(String email) {
		return repo.findByEmailId(email);
	}

	@Override
	public String deleteOwnerByOwner(Owner owner) {
		try {
            repo.delete(owner);
            return "success";
        } catch (Exception e) {
            return "Error deleting MovieCasting entities: " + e.getMessage();
        }
	}
}



