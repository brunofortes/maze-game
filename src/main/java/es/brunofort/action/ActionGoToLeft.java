package es.brunofort.action;

import es.brunofort.maze.Point;

public class ActionGoToLeft implements Action {

	@Override
	public Point moveToNextPoint(Point point) {
		return new Point(point.getPointX()-1, point.getPointY());
	}

}
