package es.brunofort.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.brunofort.maze.Point;

@Service
public class ActionService {

	public List<Point> generatePathByActions(Point begin, ArrayList<ActionType> actions, Integer maxHeight, Integer maxWidth) throws InvalidPathException{
		List<Point> path = new ArrayList<Point>();

		if(begin != null && actions != null && !actions.isEmpty()) {
			path.add(begin);
			Point actualPoint = begin;

			for(ActionType action : actions) {
				Point nextPoint = action.getAction().moveToNextPoint(actualPoint);
				path.add(nextPoint);
				actualPoint = nextPoint;
				
				if(actualPoint.getPointX() > maxWidth || actualPoint.getPointX() < 0 ||
					actualPoint.getPointY() > maxHeight || actualPoint.getPointY() < 0) {
					throw new InvalidPathException();
				}
			}
		}
		
		return path;
	}
}
