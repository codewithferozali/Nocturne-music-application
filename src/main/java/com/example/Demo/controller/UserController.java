package com.example.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.Demo.entities.Songs;
import com.example.Demo.entities.Users;
import com.example.Demo.services.SongsService;
import com.example.Demo.services.UsersService;

//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService songserv;
	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
		{
		boolean userStatus=userv.emailExist(user.getEmail());
		if(userStatus==false) {
			userv.addUser(user);
			return "registersuccess";
			}
		else {
			return "registerfail";
		}
	
		
	}
	
//	@PostMapping("/login")
//	public String validateUser( String email, String password) {
//		boolean loginStatus=userv.validateUser(email,password);
//		if(loginStatus==true) {
//			if(userv.getRole(email).equals("admin")) {
//			return "adminhome";
//			}else 
//			{
//				return "customer";
//			}
//		}
//		else {
//			return "loginfail";
//		}
//		
//	}
	
	
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,
			@RequestParam String password, HttpSession session)
	{
		//invoking validateUser() in service
		if(userv.validateUser(email, password) == true)
		{
			
			session.setAttribute("email", email);
			//checking whether the user is admin or customer
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customer";
			}
		}
		else
		{
			return "login";
		}
	}
	
	
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model) {
		
			String email = (String) session.getAttribute("email");
			
			Users user = userv.getUser(email);
			
			boolean userStatus = user.isPremium();
			if(userStatus == true) {
				List<Songs> songslist = songserv.fetchAllSongs();
				model.addAttribute("songslist", songslist);
				return "displaysongs";
			}
			else {
				return "SamplePayment";
			}
	}
	
	
	
	
	

}
