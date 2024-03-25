package in.ineuron.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Casting;
import in.ineuron.repo.CastingRepository;
import in.ineuron.service.ICastingService;

@Service
public class CastingServiceImpl implements ICastingService {
	
	@Autowired
	private CastingRepository repo;

	@Override
	@Transactional
	public String saveCasting(Casting cast) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		cast.setCreatedDate(sqlDate);
		Casting casting = repo.save(cast);
		if(casting==null) {
			return "casting not saved";
		}
		return "Casting saved with the id "+casting.getCastingId();
	}

	@Override
	public List<Casting> findAllCast() {
		List<Casting> castings = repo.findAll();
		return castings;
	}

	@Override
	public Casting findById(Integer id) {
		Optional<Casting> casting = repo.findById(id);
		return casting.get();
	}

	@Override
	public List<Casting> findCastingsByName(String name) {
		List<Casting> castings = repo.findByActor(name);
		return castings;
	}

	@Override
	public Casting findCastingByName(String name) {
		return repo.findByActorName(name);
	}

	@Override
	public String deleteCastingByCasting(Casting casting) {
		try {
            repo.delete(casting);
            return "success";
        } catch (Exception e) {
            return "Error deleting MovieCasting entities: " + e.getMessage();
        }
	}

}
