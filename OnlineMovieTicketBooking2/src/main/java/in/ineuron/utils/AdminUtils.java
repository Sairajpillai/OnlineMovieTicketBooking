package in.ineuron.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class AdminUtils {
	
	@Autowired
	private static HttpServletRequest httpRequest;
	
	@Autowired
	private static HttpSession session;
	
	public static boolean getSession() {
	session = httpRequest.getSession(false);
	if(session==null) {
		System.out.println("Invalid Session");
		return false;
	}
	
	return true;
	}
}
