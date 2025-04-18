package com.example.Demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.entities.PlayList;
import com.example.Demo.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService{
	@Autowired
PlayListRepository prepo;

	@Override
	public void addPlayList(PlayList playlist) {
		// TODO Auto-generated method stub
		prepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchPlayLists() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}
}
