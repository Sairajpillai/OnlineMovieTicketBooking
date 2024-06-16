package in.ineuron.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieTheatreMaster {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mtmid;
    
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieMaster movie;
    
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    
    @ManyToOne
    @JoinColumn(name = "tsid")
    private TheatreScreen theatreScreen;
    
    private Date movieDate;
    private Time startTime;
    private Time endTime;
    private Double amount;
	public Long getMtmid() {
		return mtmid;
	}
	public void setMtmid(Long mtmid) {
		this.mtmid = mtmid;
	}
	public MovieMaster getMovie() {
		return movie;
	}
	public void setMovie(MovieMaster movie) {
		this.movie = movie;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public TheatreScreen getTheatreScreen() {
		return theatreScreen;
	}
	public void setTheatreScreen(TheatreScreen theatreScreen) {
		this.theatreScreen = theatreScreen;
	}
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
    

}
