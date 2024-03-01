package in.ineuron.utils;

import java.util.List;

import in.ineuron.model.Casting;
import in.ineuron.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class MovieCastingUtil {
	
	private Movie movie;
	private List<Casting> casting;

}
