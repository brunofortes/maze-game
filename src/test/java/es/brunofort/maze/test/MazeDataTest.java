package es.brunofort.maze.test;

import es.brunofort.maze.Maze;
import es.brunofort.maze.Point;

public class MazeDataTest {

	public static Maze generateDemoMaze() {
		Maze maze = new Maze();
		maze.setId(1l);
		maze.setName("Demo Maze 1");
		
		maze.setBeginX(1);
		maze.setBeginY(1);
		maze.setEndX(3);
		maze.setEndY(1);
		maze.setHeight(20);
		maze.setWidth(20);
		
		maze.addPoint(new Point(2, 1));
		maze.addPoint(new Point(2, 3));
		maze.addPoint(new Point(2, 4));
		maze.addPoint(new Point(2, 5));
		
		return maze;
	}
	
}
