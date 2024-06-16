package in.ineuron.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TheatreScreen {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tsid;
    private String screenName;
    private String screenCategory;
    private int seats;
    private int occupied;
    private int vacancy;
    
    @OneToMany(mappedBy = "theatreScreen")
    private List<MovieTheatreMaster> movieTheatreMasters;

	public Long getTsid() {
		return tsid;
	}

	public void setTsid(Long tsid) {
		this.tsid = tsid;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenCategory() {
		return screenCategory;
	}

	public void setScreenCategory(String screenCategory) {
		this.screenCategory = screenCategory;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public List<MovieTheatreMaster> getMovieTheatreMasters() {
		return movieTheatreMasters;
	}

	public void setMovieTheatreMasters(List<MovieTheatreMaster> movieTheatreMasters) {
		this.movieTheatreMasters = movieTheatreMasters;
	}

    
    
}
