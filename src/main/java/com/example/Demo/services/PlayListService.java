package com.example.Demo.services;

import java.util.List;

import com.example.Demo.entities.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playlist);

	public List<PlayList> fetchPlayLists();

}
