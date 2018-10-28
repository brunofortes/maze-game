package es.brunofort.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="maze")
public class Maze implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_maze")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="maze", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	List<MazePoint> points;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MazePoint> getPoints() {
		return points;
	}

	public void setPoints(List<MazePoint> points) {
		this.points = points;
	}

}
