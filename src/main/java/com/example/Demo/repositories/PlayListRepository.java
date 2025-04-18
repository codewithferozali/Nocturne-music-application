package com.example.Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demo.entities.PlayList;


public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

}
