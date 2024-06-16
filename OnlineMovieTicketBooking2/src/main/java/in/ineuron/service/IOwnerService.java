package in.ineuron.service;

import in.ineuron.model.Owner;

public interface IOwnerService {
	
	public Owner saveOwner(Owner owner);
	
	public Owner findOwnerByemail(String email);
	
	public String deleteOwnerByOwner(Owner owner);

}
