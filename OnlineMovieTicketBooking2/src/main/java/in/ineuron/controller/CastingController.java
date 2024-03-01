package in.ineuron.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.Admin;
import in.ineuron.model.Casting;
import in.ineuron.service.IAdminService;
import in.ineuron.service.ICastingService;
import in.ineuron.service.IMovieService;

@Controller
@RequestMapping("/casting")
public class CastingController {
	
	@Autowired
	private ICastingService castingService;
	
	@GetMapping("/addCasting")
	public String castingForm(Map<String,Object> model) {
		Casting casting = new Casting();
		model.put("casting",casting);
		return "casting/castingForm";
	}
	
	@PostMapping("/addCasting")
	public String saveCasting(@ModelAttribute Casting casting,HttpSession session,Map<String,Object> model) {
		Admin admin = (Admin) session.getAttribute("admin");
		casting.setAdmin(admin);
		String saveResult = castingService.saveCasting(casting);
		model.put("saveResult", saveResult);
		return "admin/adminHomePage";
		
	}
	
	

}
