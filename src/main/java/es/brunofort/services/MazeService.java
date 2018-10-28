package es.brunofort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.brunofort.models.Maze;
import es.brunofort.repositories.MazeRepository;

@Service
public class MazeService {

	@Autowired
	private MazeRepository mazeRepository;
	
	public Maze findById(Long id) {
		return mazeRepository.findOne(id);
	}
	
}
