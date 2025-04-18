package com.example.Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.entities.Songs;
import com.example.Demo.entities.Users;
@Repository
public interface SongRepository extends JpaRepository<Songs, Integer>{
public Songs findByName(String song);
}
