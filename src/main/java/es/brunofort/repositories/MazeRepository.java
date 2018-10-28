package es.brunofort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.brunofort.models.Maze;

@Repository
public interface MazeRepository extends JpaRepository<Maze, Long>{
	
}
