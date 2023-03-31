package geometry;
import java.awt.Graphics;

public class Circle extends Shape{
	
	protected Point center;
	private int r;
	
	
	public Circle() {

	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}
	
	public double circumference() {
		return 2 * r * Math.PI;
	}
	
	public double area() {
		return r * r * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}
	
	@Override
	public String toString() {
		return "Center: " + center + ", radius: " + r;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if (center.equals(temp.center) && r == temp.r) {
				return true;
			}
		}
		return false;
	}
	
	//dodato
	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-r, center.getY()-r,
					r*2, r*2);
	}
	
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}
