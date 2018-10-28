package es.brunofort.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="maze_point", uniqueConstraints={@UniqueConstraint(columnNames = {"id_maze" , "point_x", "point_y"})})
public class MazePoint implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_maze_point")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_maze", nullable=false)
	private Maze maze;	
	
	@Column(name="point_x", nullable=false)
	private Integer pointX;
	
	@Column(name="point_y", nullable=false)
	private Integer pointY;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public Integer getPointX() {
		return pointX;
	}

	public void setPointX(Integer pointX) {
		this.pointX = pointX;
	}

	public Integer getPointY() {
		return pointY;
	}

	public void setPointY(Integer pointY) {
		this.pointY = pointY;
	}
	
}
