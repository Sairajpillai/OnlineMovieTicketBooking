package in.ineuron.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String adminName;
	
	@Column(nullable = false)
	private Date createdDate;
	
	private Date modifiedDate;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Movie> movies;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Casting> castings;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Owner> owners;

//	@Override
//	public String toString() {
//		return "Admin [adminId=" + adminId + ", password=" + password + ", adminName=" + adminName + ", createdDate="
//				+ createdDate + ", modifiedDate=" + modifiedDate + ", movies=" + movies + ", castings=" + castings
//				+ "]";
//	}
	
	

}
