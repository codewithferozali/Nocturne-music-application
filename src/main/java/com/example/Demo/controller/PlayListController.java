package com.example.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Demo.entities.PlayList;
import com.example.Demo.entities.Songs;
import com.example.Demo.services.PlayListService;
import com.example.Demo.services.SongsService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class PlayListController {
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createplaylist")
	public String createPlayList(Model model) {
		//fetching the songs in songservice
	List<Songs>	songslist=sserv.fetchAllSongs();
	//adding the songs to model
	model.addAttribute("songslist", songslist);
	//sending createplayist
	return "createplaylist";
		}
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		
		//System.out.println(playlist);
		pserv.addPlayList(playlist);
		
		//update the song list
		List<Songs> songslist=playlist.getSongs();
		for(Songs song:songslist) {
			song.getPlaylist().add(playlist);
			sserv.updateSongs(song);
		}
		return "playlistsuccess";
	}
	
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model model) {
		List<PlayList> plist=pserv.fetchPlayLists();
		//System.out.println(plist);
		model.addAttribute("plist", plist);
		return "viewPlayList";
	
	}
	
	

}
