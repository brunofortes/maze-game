package es.brunofort.maze.test;

import es.brunofort.maze.Maze;
import es.brunofort.maze.Point;

public class MazeDataTest {

	public static Maze generateDemoMaze() {
		Maze maze = new Maze();
		maze.setId(1l);
		maze.setName("Demo Maze 1");
		
		maze.setBegin(new Point(1, 1));
		maze.setEnd(new Point(3, 1));
		
		maze.addPoint(new Point(2, 1));
		maze.addPoint(new Point(2, 3));
		maze.addPoint(new Point(2, 4));
		maze.addPoint(new Point(2, 5));
		
		return maze;
	}
	
}
