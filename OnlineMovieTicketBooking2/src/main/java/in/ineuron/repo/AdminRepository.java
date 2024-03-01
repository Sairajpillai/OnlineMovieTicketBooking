package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ineuron.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("SELECT a FROM Admin a WHERE a.adminId = :adminid AND a.password = :password")
	Admin findByAdminIdAndPassword(@Param("adminid") Integer adminId,@Param("password") String password);

}
