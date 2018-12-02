package es.brunofort.home;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.brunofort.action.ActionType;
import es.brunofort.action.InvalidPathException;
import es.brunofort.maze.Maze;
import es.brunofort.maze.MazeService;
import es.brunofort.maze.Point;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
	@Autowired
	private MazeService mazeService;

	@ModelAttribute("module")
	public String module() {
		return "home";
	}

	@GetMapping("/")
	public String index(Model model) {
		return indexId(model, mazeService.selectRandoId());
	}

	@GetMapping("/{id}")
	public String indexId(Model model, @PathVariable(value="id") Long id) {
		Maze maze = mazeService.findById(id);		
		model.addAttribute("maze", maze);
		return "home/home";
	}
	
	@PostMapping("/solution/{id}")
	public String postMazeSolution(@RequestBody ArrayList<ActionType> actions, @PathVariable(value="id") Long id, Model model) {
		Maze maze = mazeService.findById(id);
		Boolean success = true;
		
		try {
			Set<Point> intersection = mazeService.validateActionsForMazeAndReturnCollisions(actions, maze);
			if(intersection != null && intersection.size() > 0) {
				success = false;
			}
		} catch (InvalidPathException e) {
			success = false;
		}
		
		model.addAttribute("success", success);
		model.addAttribute("idmaze", id);
		return "fragments/maze :: result";
	}
}
