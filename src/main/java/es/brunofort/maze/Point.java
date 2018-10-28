package es.brunofort.maze;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="point", uniqueConstraints={@UniqueConstraint(columnNames = {"point_x", "point_y"})})
public class Point implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_point")
	private Long id;
	
	@Column(name="point_x", nullable=false)
	private Integer pointX;
	
	@Column(name="point_y", nullable=false)
	private Integer pointY;

	public Point() {
		super();
	}

	public Point(Integer pointX, Integer pointY) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointX == null) ? 0 : pointX.hashCode());
		result = prime * result + ((pointY == null) ? 0 : pointY.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (pointX == null) {
			if (other.pointX != null)
				return false;
		} else if (!pointX.equals(other.pointX))
			return false;
		if (pointY == null) {
			if (other.pointY != null)
				return false;
		} else if (!pointY.equals(other.pointY))
			return false;
		return true;
	}

}
