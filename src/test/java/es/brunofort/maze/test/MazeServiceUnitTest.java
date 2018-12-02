package es.brunofort.maze.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import es.brunofort.action.ActionService;
import es.brunofort.action.ActionType;
import es.brunofort.action.InvalidPathException;
import es.brunofort.maze.Maze;
import es.brunofort.maze.MazeRepository;
import es.brunofort.maze.MazeService;
import es.brunofort.maze.Point;

@RunWith(MockitoJUnitRunner.class)
public class MazeServiceUnitTest {

	@InjectMocks
	private MazeService mazeService;

	@InjectMocks
	private ActionService actionService = new ActionService();

	@Mock
	private MazeRepository mazeRepositoryMock;

	@Rule
    public ExpectedException thrown = ExpectedException.none();	
	
	@Before
	public void init() {
		this.mazeService = new MazeService(mazeRepositoryMock, actionService);
	}

	
	@Test
	public void shouldReturnAMazeWhenFindById() {
		Mockito.when(mazeRepositoryMock.findByIdFetchingPoints(Mockito.anyLong())).thenReturn(MazeDataTest.generateDemoMaze());
		Maze maze = mazeService.findById(1l);
		
		assertEquals(Long.valueOf(1L), maze.getId());
	}
	
	@Test
	public void shouldReturnCollisionsBetweenPathAndMaze() throws InvalidPathException  {
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.RIGHT);

		Mockito.when(mazeRepositoryMock.findByIdFetchingPoints(Mockito.anyLong())).thenReturn(MazeDataTest.generateDemoMaze());
		Maze maze = mazeService.findById(1l);
		
		Set<Point> collisions = mazeService.validateActionsForMazeAndReturnCollisions(actions, maze);
		assertEquals(1, collisions.size());
	}

	@Test
	public void shouldNotReturnCollisionsBetweenPathAndMaze() throws InvalidPathException  {
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.TOP);
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.DOWN);

		Mockito.when(mazeRepositoryMock.findByIdFetchingPoints(Mockito.anyLong())).thenReturn(MazeDataTest.generateDemoMaze());
		Maze maze = mazeService.findById(1l);
		
		Set<Point> collisions = mazeService.validateActionsForMazeAndReturnCollisions(actions, maze);
		assertEquals(0, collisions.size());
	}

	@Test
	public void invalidPathBecauseNotFindMazeEnd() throws InvalidPathException {
		ArrayList<ActionType> actions = new ArrayList<ActionType>();
		actions.add(ActionType.TOP);
		actions.add(ActionType.RIGHT);
		actions.add(ActionType.RIGHT);

		Mockito.when(mazeRepositoryMock.findByIdFetchingPoints(Mockito.anyLong())).thenReturn(MazeDataTest.generateDemoMaze());
		Maze maze = mazeService.findById(1l);
		
		thrown.expect(InvalidPathException.class);

		mazeService.validateActionsForMazeAndReturnCollisions(actions, maze);
	}
	
}
