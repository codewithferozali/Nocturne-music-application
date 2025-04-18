package com.example.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Demo.entities.Songs;
import com.example.Demo.services.SongsService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongsController {
	@Autowired
	SongsService songserv;
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs song) {
		String name=song.getName();
	boolean songstatus=songserv.songExist(name);
	if(songstatus==false) {
		songserv.addSongs(song);
		return "songsuccess";
	}else {
		return "songfail";
	}
		
	}
	
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
		List<Songs> songslist=songserv.fetchAllSongs();
		model.addAttribute("songslist",songslist);
		return "displaysongs";
	}
	
	@GetMapping("/viewsongs")
	public String viewCustomerSongs(Model model) {
		boolean primeStatus =false;
		if(primeStatus==true) {
			List<Songs> songslist=songserv.fetchAllSongs();
			model.addAttribute("songslist",songslist);
			return "displaysongs";
		}else {
			return "makepayment";
		}
	}
	
	
	
	

}
