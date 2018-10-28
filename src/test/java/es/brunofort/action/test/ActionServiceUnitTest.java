package es.brunofort.action.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import es.brunofort.action.ActionService;
import es.brunofort.action.ActionType;
import es.brunofort.action.InvalidPathException;
import es.brunofort.maze.Point;

@RunWith(MockitoJUnitRunner.class)
public class ActionServiceUnitTest {

	@InjectMocks
	private ActionService actionService = new ActionService();
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldMove2PointsToRight() throws InvalidPathException {
		Point begin = new Point(2, 3);
		Point expectedEnd = new Point(4, 3);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.RIGHT);

		Set<Point> path = actionService.generatePathByActions(begin, actions, 10, 10);
		
		assertTrue(path.contains(expectedEnd));
		assertEquals(3, path.size());
	}

	@Test
	public void shouldMove2PointsToLeft() throws InvalidPathException  {
		Point begin = new Point(4, 3);
		Point expectedEnd = new Point(2, 3);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.LEFT);
		actions.add(ActionType.LEFT);

		Set<Point> path = actionService.generatePathByActions(begin, actions, 10, 10);
		
		assertTrue(path.contains(expectedEnd));
		assertEquals(3, path.size());
	}

	@Test
	public void shouldMove2PointsToTop() throws InvalidPathException  {
		Point begin = new Point(2, 3);
		Point expectedEnd = new Point(2, 5);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.TOP);
		actions.add(ActionType.TOP);

		Set<Point> path = actionService.generatePathByActions(begin, actions, 10, 10);
		
		assertTrue(path.contains(expectedEnd));
		assertEquals(3, path.size());
	}

	@Test
	public void shouldMove2PointsToDown() throws InvalidPathException  {
		Point begin = new Point(2, 5);
		Point expectedEnd = new Point(2, 3);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.DOWN);
		actions.add(ActionType.DOWN);

		Set<Point> path = actionService.generatePathByActions(begin, actions, 10, 10);
		
		assertTrue(path.contains(expectedEnd));
		assertEquals(3, path.size());
	}

	@Test
	public void validadePathTop() throws InvalidPathException {
		Point begin = new Point(2, 2);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.TOP);
		actions.add(ActionType.TOP);
		actions.add(ActionType.TOP);
		
		thrown.expect(InvalidPathException.class);

		actionService.generatePathByActions(begin, actions, 4, 10);
	}
	
	@Test
	public void validadePathRight() throws InvalidPathException {
		Point begin = new Point(2, 2);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.RIGHT);
		
		thrown.expect(InvalidPathException.class);

		actionService.generatePathByActions(begin, actions, 10, 4);
	}
	
	@Test
	public void validadePathDown() throws InvalidPathException {
		Point begin = new Point(2, 2);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.DOWN);
		actions.add(ActionType.DOWN);
		actions.add(ActionType.DOWN);
		
		thrown.expect(InvalidPathException.class);

		actionService.generatePathByActions(begin, actions, 10, 10);
	}
	
	@Test
	public void validadePathLeft() throws InvalidPathException {
		Point begin = new Point(2, 2);
		
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.LEFT);
		actions.add(ActionType.LEFT);
		actions.add(ActionType.LEFT);
		
		thrown.expect(InvalidPathException.class);

		actionService.generatePathByActions(begin, actions, 10, 10);
	}
	
}
