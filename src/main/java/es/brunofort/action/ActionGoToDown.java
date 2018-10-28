package es.brunofort.action;

import es.brunofort.maze.Point;

public class ActionGoToDown implements Action {

	@Override
	public Point moveToNextPoint(Point point) {
		return new Point(point.getPointX(), point.getPointY()-1);
	}

}
