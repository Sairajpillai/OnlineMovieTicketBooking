package in.ineuron.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	
	@Column(nullable = false)
	private String movieName;
	
	@Column(nullable = false)
	private String directorName;
	
	@Column(nullable = false)
	private Date releaseDate;
	
	@Column(nullable = false)
	private Date createdDate;
	
	private Date closedDate;
	
	private Date modifiedDate;
	
	@ManyToOne
    @JoinColumn(name = "adminId")
	private Admin admin;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MovieUpdate> movieAudits = new HashSet<>();

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", directorName=" + directorName
				+ ", releaseDate=" + releaseDate + ", createdDate=" + createdDate + ", closedDate=" + closedDate
				+ ", modifiedDate=" + modifiedDate + ", admin=" + admin + ", movieAudits=" + movieAudits + "]";
	}
	
	@OneToMany(mappedBy = "movie")
    private Set<MovieCasting> movieCasting;

}
