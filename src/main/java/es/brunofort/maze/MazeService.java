package es.brunofort.maze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.brunofort.action.ActionService;
import es.brunofort.action.ActionType;
import es.brunofort.action.InvalidPathException;

@Service
public class MazeService {

	private MazeRepository mazeRepository;
	
	private ActionService actionService;
	
	@Autowired
	public MazeService(MazeRepository mazeRepository, ActionService actionService) {
		super();
		this.mazeRepository = mazeRepository;
		this.actionService = actionService;
	}

	public Maze findById(Long id) {
		return mazeRepository.findOne(id);
	}
	
	public Set<Point> validateActionsForMazeAndReturnCollisions(ArrayList<ActionType> actions, Maze maze) throws InvalidPathException{
		Set<Point> path = actionService.generatePathByActions(maze.getBegin(), actions, maze.getHeight(), maze.getWidth());
		Set<Point> intersection = new HashSet<Point>(path);
		intersection.retainAll(maze.getPoints());
		return intersection;
	}
	
}
