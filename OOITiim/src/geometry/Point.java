package geometry;
import java.awt.Graphics;
public class Point extends Shape {
	
	private int x;
	private int y;

	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		this.x=x;
		this.y=y;
		this.selected=selected;
	}
	
	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	
	
	
	//ovo
	@Override
	public void draw(Graphics g) {
		g.drawLine(x + 2, y, x - 2, y);
		g.drawLine(x, y + 2, x, y - 2);
		if(selected) {
			g.drawRect(this.x - 4, this.y - 4, 8, 8);
		}
	}

	public boolean contains(int x, int y) {
		return distance(x, y) <= 2;
	}

	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if (x == temp.x && y == temp.y) {
				return true;
			}
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		y = newY;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}