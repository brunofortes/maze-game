package es.brunofort.maze;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MazeRepository extends JpaRepository<Maze, Long>{
	
	@Query("select m from Maze m join fetch m.points where m.id = :id")
	public Maze findByIdFetchingPoints(@Param("id") Long id);
	
	@Query(value="select id_maze from maze ORDER BY random()  limit 1", nativeQuery=true)
	public Long selectRandoId();
	
}
