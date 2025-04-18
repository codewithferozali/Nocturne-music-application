package com.example.Demo.services;

import java.util.List;

import com.example.Demo.entities.Songs;

public interface SongsService {
public String addSongs(Songs song);
public boolean songExist(String name);
public List<Songs> fetchAllSongs();


public void updateSongs(Songs song);
}
