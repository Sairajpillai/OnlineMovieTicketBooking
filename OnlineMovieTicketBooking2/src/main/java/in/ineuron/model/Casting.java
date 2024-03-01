package in.ineuron.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Casting {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer castingId;

	@Column(nullable = false)
    private String actor;
	
	private Date createdDate;
	
	@ManyToOne
    @JoinColumn(name = "adminId")
	private Admin admin;

    @OneToMany(mappedBy = "casting")
    private Set<MovieCasting> movieCasting;


}
