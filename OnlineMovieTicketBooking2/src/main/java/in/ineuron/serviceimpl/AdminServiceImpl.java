package in.ineuron.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Admin;
import in.ineuron.repo.AdminRepository;
import in.ineuron.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private AdminRepository repo;

	@Override
	public Admin findByIdAndPassword(Integer adminId,String password) {
		Admin admin = repo.findByAdminIdAndPassword(adminId, password);
		return admin;
	}

}
