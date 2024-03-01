package in.ineuron.service;

import in.ineuron.model.Admin;

public interface IAdminService {
	
	public Admin findByIdAndPassword(Integer adminId,String password);

}
