package es.brunofort.action;

import es.brunofort.maze.Point;

public interface Action {
	
	Point moveToNextPoint(Point point);
	
}
