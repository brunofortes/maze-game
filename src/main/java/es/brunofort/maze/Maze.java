package es.brunofort.maze;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="maze")
public class Maze implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_maze")
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "maze_points", joinColumns = @JoinColumn(name = "maze_id"), inverseJoinColumns = @JoinColumn(name = "point_id"))
	private Set<Point> points = new HashSet<Point>();
	
	@ManyToOne
	@JoinColumn(name="id_point_begin", nullable=false)
	private Point begin;

	@ManyToOne
	@JoinColumn(name="id_point_end", nullable=false)
	private Point end;
	
	@Column(nullable=false)
	private Integer height;

	@Column(nullable=false)
	private Integer width;
	
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

	public Set<Point> getPoints() {
		return points;
	}

	public void setPoints(Set<Point> points) {
		this.points = points;
	}

	public void addPoint(Point point) {
		if(this.points == null) {
			this.points = new HashSet<Point>();
		}
		this.points.add(point);
	}

	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	
}
