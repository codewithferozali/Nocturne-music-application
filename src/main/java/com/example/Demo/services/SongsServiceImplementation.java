package com.example.Demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.entities.Songs;
import com.example.Demo.repositories.SongRepository;
@Service
public class SongsServiceImplementation implements SongsService {
	
	 @Autowired
    SongRepository srepo;
   
	@Override
	public String addSongs(Songs song) {
		srepo.save(song);
		return "song is added";
	}

	@Override
	public boolean songExist(String name) {
		Songs song=srepo.findByName(name);
		if(song==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs> songslist=srepo.findAll();
		return songslist;
	}

	@Override
	public void updateSongs(Songs song) {
		// TODO Auto-generated method stub
		srepo.save(song);
		
	}

}
