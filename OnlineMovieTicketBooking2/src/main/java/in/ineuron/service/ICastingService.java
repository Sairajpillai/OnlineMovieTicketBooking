package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Casting;

public interface ICastingService {
	
	public String saveCasting(Casting cast);
	
	public List<Casting> findAllCast();
	
	public Casting findById(Integer id);
	
	public List<Casting> findCastingsByName(String name);
	
	public Casting findCastingByName(String name);
	
	public String deleteCastingByCasting(Casting casting);

}
