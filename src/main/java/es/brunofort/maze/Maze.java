package es.brunofort.maze;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "maze", cascade = CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Point> points = new HashSet<Point>();
	
	@Column(nullable=false)
	private Integer height;

	@Column(nullable=false)
	private Integer width;
	
	@Column(name="begin_x", nullable=false)
	private Integer beginX;

	@Column(name="begin_y", nullable=false)
	private Integer beginY;
	
	@Column(name="end_x", nullable=false)
	private Integer endX;

	@Column(name="end_y", nullable=false)
	private Integer endY;
	
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

	public Point getBegin() {
		return new Point(beginX, beginY);
	}

	public Point getEnd() {
		return new Point(endX, endY);
	}

	public Integer getBeginX() {
		return beginX;
	}

	public void setBeginX(Integer beginX) {
		this.beginX = beginX;
	}

	public Integer getBeginY() {
		return beginY;
	}

	public void setBeginY(Integer beginY) {
		this.beginY = beginY;
	}

	public Integer getEndX() {
		return endX;
	}

	public void setEndX(Integer endX) {
		this.endX = endX;
	}

	public Integer getEndY() {
		return endY;
	}

	public void setEndY(Integer endY) {
		this.endY = endY;
	}

}
