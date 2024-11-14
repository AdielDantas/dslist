package com.gamecollection.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamecollection.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
