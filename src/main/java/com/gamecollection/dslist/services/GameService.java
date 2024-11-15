package com.gamecollection.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamecollection.dslist.dto.GameDto;
import com.gamecollection.dslist.dto.GameMinDto;
import com.gamecollection.dslist.entities.Game;
import com.gamecollection.dslist.projection.GameMinProjection;
import com.gamecollection.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDto(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listid){
		List<GameMinProjection> result = gameRepository.searchByList(listid);
		return result.stream().map(x -> new GameMinDto(x)).toList();
	}

}
