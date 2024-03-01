package in.ineuron.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class MovieCasting {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long movieCastingId;

	    @ManyToOne
	    @JoinColumn(name = "movieId")
	    private Movie movie;

	    @ManyToOne
	    @JoinColumn(name = "castingId")
	    private Casting casting;

}
