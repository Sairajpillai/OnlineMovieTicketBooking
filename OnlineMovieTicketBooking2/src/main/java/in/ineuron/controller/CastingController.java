package in.ineuron.controller;

import java.util.List;
import java.util.Map;

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
import in.ineuron.service.ICastingService;
import in.ineuron.utils.AdminLoginRequest;

@Controller
@RequestMapping("/casting")
public class CastingController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ICastingService castingService;
	
	@Autowired
	private HttpServletRequest httpRequest;
	
	
	public boolean isLoggedIn() {
		HttpSession session = httpRequest.getSession(false);
		if(session==null) {
			System.out.println("Invalid Session");
			return false;
		}
		System.out.println(session.getAttribute("admin"));
		return true;
		//return AdminUtils.getSession();
	}
	
	@GetMapping("/addCasting")
	public String castingForm(Map<String,Object> model) {
		if(isLoggedIn()) {
		Casting casting = new Casting();
		model.put("casting",casting);
		return "casting/castingForm";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/addCasting")
	public String saveCasting(@ModelAttribute Casting casting,Map<String,Object> model) {
		if(isLoggedIn()) {
		Admin admin = (Admin) session.getAttribute("admin");
		System.out.println(admin+" inside admin");
		casting.setAdmin(admin);
		String saveResult = castingService.saveCasting(casting);
		model.put("saveResult", saveResult);
		return "admin/adminHomePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
		
	}
	
	@GetMapping("/searchCasting")
	public String searchCastingForm(Map<String,Object> model) {
		if(isLoggedIn()) {
			//castingService.findCastingsByName(null);
			return "casting/castingSearch";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/searchCasting")
	public String searchCasting(@RequestParam("castingName") String castingName,Map<String,Object> model) {
		if(isLoggedIn()) {
		System.out.println(castingName);
		List<Casting> castingsList = castingService.findCastingsByName(castingName);
//		for (Casting casting : castingsList) {
//			System.out.println(casting.getActor());
//		
//		}
		
		model.put("castingList", castingsList);
		return "casting/castingSearchCastingResult";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
		
	}
	
	@GetMapping("/updateCasting")
	public String updateCastingForm(Map<String,Object> model) {
		if(isLoggedIn()) {
			return "casting/castingUpdatePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/updateCasting")
	public String updateCasting(@RequestParam("castingName") String castingName,Map<String,Object> model) {
		if(isLoggedIn()) {
			Casting casting = castingService.findCastingByName(castingName);
			System.out.println(casting.getActor());
			model.put("casting", casting);
			return "casting/castingUpdatePageResult";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/updateCastingController")
	public String updateCastingController(@ModelAttribute Casting casting,Map<String,Object> model) {
		if(isLoggedIn()) {
			Admin admin = (Admin) session.getAttribute("admin");
			casting.setAdmin(admin);
			String saveResult = castingService.saveCasting(casting);
			model.put("saveResult", saveResult);
			return "admin/adminHomePage";
	
	}else {
		AdminLoginRequest adminLogin = new AdminLoginRequest();
		model.put("adminLogin", adminLogin);
		model.put("isAdmin", "sessionExpired");
		return "admin/adminLoginPage";
	}
	}
	
	@GetMapping("/deleteCasting")
	public String deleteCastingForm(Map<String,Object> model) {
		if(isLoggedIn()) {
			return "casting/castingDeletePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
		
	}
	
	@PostMapping("/deleteCasting")
	public String deleteCastingController(@RequestParam("castingName") String castingName,Map<String,Object> model) {
		if(isLoggedIn()) {
			Casting casting = castingService.findCastingByName(castingName);
			System.out.println(casting.getActor());
			model.put("casting", casting);
			return "casting/castingDeletePageResult";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	
	@PostMapping("/deleteCastingController")
	public String deleteCasting(@ModelAttribute Casting casting,Map<String,Object> model) {
		if(isLoggedIn()) {
			String deleteStatus = castingService.deleteCastingByCasting(casting);
			model.put("castingDeleteStatus",deleteStatus);
			//AdminLoginRequest adminLogin = new AdminLoginRequest();
			//model.put("castingDeleteStatus","success");
			return "admin/adminHomePage";
		}else {
			AdminLoginRequest adminLogin = new AdminLoginRequest();
			model.put("adminLogin", adminLogin);
			model.put("isAdmin", "sessionExpired");
			return "admin/adminLoginPage";
		}
	}
	

}
