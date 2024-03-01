package in.ineuron.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Admin;
import in.ineuron.model.Casting;
import in.ineuron.model.Movie;
import in.ineuron.model.MovieCasting;
import in.ineuron.model.MovieUpdate;
import in.ineuron.service.IAdminService;
import in.ineuron.service.ICastingService;
import in.ineuron.service.IMovieCastingService;
import in.ineuron.service.IMovieService;
import in.ineuron.service.IMovieUpdateService;
import in.ineuron.utils.AdminLoginRequest;
import in.ineuron.utils.MovieCastingUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private HttpServletRequest httpRequest;
	
	@Autowired
	private IAdminService service;
	
	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private ICastingService castingService;
	
	@Autowired
	private IMovieCastingService mcs;
	
	@Autowired
	private IMovieUpdateService mus;
	
	//private HttpSession session;
	
	public boolean isLoggedIn() {
		HttpSession session = httpRequest.getSession(false);
		if(session==null) {
			System.out.println("Invalid Session");
			return false;
		}
		
		return true;
	}
	
	@GetMapping("/adminLogin")
	public String loginForm(Map<String,Object> model) {
		System.out.println("Reached Admin Login");
		AdminLoginRequest adminLogin = new AdminLoginRequest();
		model.put("adminLogin",adminLogin);
		return "admin/adminLoginPage";
	}
	
	@PostMapping("/adminLogin")
		public String adminLoginMethod(@ModelAttribute AdminLoginRequest adminLoginRequest,HttpSession session,Map<String,Object> model) {
		String isAdmin = "";
		Integer loginid = Integer.parseInt(adminLoginRequest.getLoginId());
		String password = adminLoginRequest.getPassword();
		
		System.out.println(loginid+" "+password);
		
		Admin admin = service.findByIdAndPassword(loginid,password);
		//this.session=session;
		//session.setAttribute("admin", admin);
		httpSession = httpRequest.getSession();
		httpSession.setAttribute("admin", admin);
		if(admin==null) {
			isAdmin="failure";
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("isAdmin", isAdmin);
			model.put("adminLogin", adminLogin);
			//session.setAttribute("isAdmin", isAdmin);		//return "redirect:adminLogin";
			httpSession.setAttribute("isAdmin", isAdmin);
			return "admin/adminLoginPage";
		}else {
			isAdmin="success";
			//session.setAttribute("loginid", loginid);
			httpSession.setAttribute("loginid", loginid);
			httpSession.setAttribute("isAdmin", isAdmin);		
			model.put("isAdmin", isAdmin);
			return "admin/adminHomePage";
		}
		 
	}
	
	@GetMapping("/addMovie")
	public String addMovieForm(Map<String,Object> model) {
		if(isLoggedIn()) {
		List<Casting> castList = castingService.findAllCast();
		Movie movie = new Movie();
		model.put("movie",movie);
		model.put("castList", castList);
		return "admin/adminMovieAdd";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/addMovie")
	public String addMovie(@ModelAttribute Movie movie,
			@RequestParam("selectedActor1") String actor1,
			@RequestParam("selectedActor2") String actor2,
			HttpSession session,Map<String,Object> model) {
		if(isLoggedIn()) {
		//Admin admin = (Admin) session.getAttribute("admin");
		Admin admin = (Admin) httpSession.getAttribute("admin");
		System.out.println(admin);
		System.out.println(actor1+" "+actor2);
		
		//Casting casting = castingService.findById(Integer.parseInt(castList.get(0)));
		//System.out.println(casting);
		
//		movie.setAdmin(admin);
//		System.out.println(movie);
//		String saveResult = movieService.saveMovie(movie);
//		System.out.println(saveResult);
//		model.put("saveResult", saveResult);
//		return "admin/adminHomePage";
		System.out.println(actor1+" "+actor2);
		movie.setAdmin(admin);
		Movie m = movieService.saveMovie(movie);
		if(m!=null) {
			String saveResult = "Movie Saved with the id "+m.getMovieId();
			model.put("saveResult", saveResult);
		}
		if(m!=null) {
		if(!"empty".equals(actor1)) {
			Casting casting = castingService.findById(Integer.parseInt(actor1));
			MovieCasting movieCasting = new MovieCasting();
			movieCasting.setCasting(casting);
			movieCasting.setMovie(m);
			String mcsResult = mcs.saveMovieCasting(movieCasting);
			System.out.println(mcsResult);
		}
		if(!"empty".equals(actor2)) {
			Casting casting = castingService.findById(Integer.parseInt(actor2));
			MovieCasting movieCasting = new MovieCasting();
			movieCasting.setCasting(casting);
			movieCasting.setMovie(m);
			String mcsResult = mcs.saveMovieCasting(movieCasting);
			System.out.println(mcsResult);
		}
		}
		
		return "admin/adminHomePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@GetMapping("searchMovie")
	public String searchMovieForm(Map<String,Object> model) {
		if(isLoggedIn()) {
			
			return "admin/adminSearchMovie";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("searchMovie")
	public String searchMovie(@RequestParam("movieName") String movieName,Map<String,Object> model) {
		if(isLoggedIn()) {
		List<Movie> movieList = movieService.searchMovie(movieName);
		System.out.println(movieList.size()+" movie list size");
//		List<MovieCastingUtil> mcuList = new ArrayList<>();
//		//trial
//		for (Movie movie : movieList) {
//			List<Integer> findCastingIdsByMovieId = mcs.findCastingIdsByMovieId(movie.getMovieId());
//			System.out.println(findCastingIdsByMovieId+" casting ids");
//		}
//		
//		
//		//trial end
//		for (Movie movie : movieList) {
//			
//			MovieCastingUtil mcu = new MovieCastingUtil();
//			mcu.setMovie(movie);
//			List<Casting> castingList = mcs.findCastingByMovieId(movie.getMovieId());
//			for (Casting  cast: castingList) {
//				System.out.println(cast.getActor());
//			}
//			mcu.setCasting(castingList);
//			mcuList.add(mcu);
//			System.out.println(movie.getMovieId()+" id");
//		}
//		for (MovieCastingUtil obj : mcuList) {
//			System.out.println(obj.getMovie()+" "+obj.getCasting());
//		}
//		//return "admin/adminSearchMovieResult";
//		return null;
//	}
		for (Movie movie : movieList) {
			List<Integer> findCastingIdsByMovieId = mcs.findCastingIdsByMovieId(movie.getMovieId());
			System.out.println(findCastingIdsByMovieId+" casting ids");
		}
		
		List<MovieCastingUtil> mcuList = new ArrayList<>();
		for (Movie movie : movieList) {
			
			MovieCastingUtil mcu = new MovieCastingUtil();
			mcu.setMovie(movie);
			List<Casting> castingList = mcs.findCastingByMovieId(movie.getMovieId());
			for (Casting  cast: castingList) {
				System.out.println(cast.getActor());
			}
			mcu.setCasting(castingList);
			mcuList.add(mcu);
			System.out.println(movie.getMovieId()+" id");
		}
		for (MovieCastingUtil obj : mcuList) {
			System.out.println(obj.getMovie()+" "+obj.getCasting());
		}
		model.put("moviesList", mcuList);
		return "admin/adminSearchMovieResult";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
		
	}
	
	@GetMapping("/updateMovie")
	public String updateMovieForm(Map<String,Object> model) {
		if(isLoggedIn()) {
			return "admin/adminUpdatePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/updateMovie")
	public String updateMovieController(@RequestParam("movieName") String movieName, Map<String,Object> model) {
		if(isLoggedIn()) {
		System.out.println(movieName);
		Movie movie = movieService.findMovie(movieName);
		List<Casting> castingList=null;
		if(movie==null) {
			model.put("movie", movie);
		}else {
			List<Casting> castList = castingService.findAllCast();
			castingList = mcs.findCastingByMovieId(movie.getMovieId());
			model.put("movie", movie);
			model.put("castList",castList);
			model.put("castingList", castingList);
			//session.setAttribute("castingList", castingList);
		}
		System.out.println(movie.getMovieName() + " "+ castingList.get(0).getActor()+" "+castingList.get(1).getActor());
		//System.out.println(movie+" inside movieController"+castingList);
		return "admin/adminUpdatePageResult";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/updateMovieController")
	public String updateMovie(@ModelAttribute Movie movie,
			@RequestParam("selectedActor1") String actor1,
			@RequestParam("selectedActor2") String actor2,
			Map<String,Object> model,HttpSession session) {
		if(isLoggedIn()) {
		System.out.println(movie);
		System.out.println(actor1);
		System.out.println(actor2);
		
		Admin admin = (Admin) httpSession.getAttribute("admin");
		MovieUpdate movieUpdate = new MovieUpdate();
		movieUpdate.setMovie(movie);
		movieUpdate.setModifiedBy(admin);
		MovieUpdate mUpdate = mus.saveMovieUpdate(movieUpdate);
		Set<MovieUpdate> movieUpdateSet = new HashSet<>();
		movieUpdateSet.add(mUpdate);
		movie.setAdmin(admin);
		movie.setMovieAudits(movieUpdateSet);
		Movie updateMovieSaved = movieService.saveMovie(movie);	
		System.out.println(updateMovieSaved);
		
		List<MovieCasting> castingList = mcs.findMovieCastingBymovie(movie);
		Casting casting1 = castingService.findById(Integer.parseInt(actor1));
		Casting casting2 = castingService.findById(Integer.parseInt(actor2));
		MovieCasting movieCasting = castingList.get(0);
		movieCasting.setCasting(casting1);
		movieCasting.setMovie(movie);
		String saveMovieCasting1 = mcs.saveMovieCasting(movieCasting);
		
		System.out.println(saveMovieCasting1+" MovieCasting Table saved");
		
		MovieCasting movieCasting1 = castingList.get(1);
		movieCasting1.setCasting(casting2);
		movieCasting1.setMovie(movie);
		String saveMovieCasting2 = mcs.saveMovieCasting(movieCasting1);
		
		System.out.println(saveMovieCasting2+" MovieCasting Table saved");
		model.put("updateResult","success");
		return "admin/adminHomePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@GetMapping("/movieDeletePage")
	public String deleteMoviePage(Map<String,Object> model) {
		if(isLoggedIn()) {
			return "admin/adminMovieDeletePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/deleteMovie")
	public String deleteMovieController(@RequestParam("movieName") String movieName,Map<String,Object> model) {
		if(isLoggedIn()) {
			System.out.println(movieName);
			Movie movie = movieService.findMovie(movieName);
			List<Casting> castingList=null;
			if(movie==null) {
				model.put("movie", movie);
			}else {
				List<Casting> castList = castingService.findAllCast();
				castingList = mcs.findCastingByMovieId(movie.getMovieId());
				model.put("movie", movie);
				model.put("castList",castList);
				model.put("castingList", castingList);
				//session.setAttribute("castingList", castingList);
			}
			System.out.println(movie.getMovieName() + " "+ castingList.get(0).getActor()+" "+castingList.get(1).getActor());
			//System.out.println(movie+" inside movieController"+castingList);
			return "admin/adminDeletePageResult";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
		
	}
	
	@PostMapping("/deleteMovieController")
	public String deleteMovie(@ModelAttribute Movie movie,Map<String,Object> model) {
		if(isLoggedIn()) {
			System.out.println(movie);
			String movieCastingdeleteStatus="failure";
			String deleteMovieUpdateListByMovie="failure";
			String movieDeleteStatus="failure";
			List<MovieCasting> movieCastings = mcs.findMovieCastingBymovie(movie);
			if(movieCastings.size()>0) {
				movieCastingdeleteStatus = mcs.deleteMovieCastingsByMovieCasting(movieCastings);
			}
			List<MovieUpdate> movieUpdates = mus.getMovieUpdateListByMovie(movie);
			if(movieUpdates.size()>0) {
				deleteMovieUpdateListByMovie = mus.deleteMovieUpdateListByMovie(movieUpdates);
			}
			if(movie!=null) {
				movieDeleteStatus = movieService.deleteMovieByMovie(movie);
			}
			System.out.println(movieDeleteStatus);
			
			model.put("movieDeleteStatus","success");
			return "admin/adminHomePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	
	
	
	

} 
