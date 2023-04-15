package geometry;
import java.awt.Graphics;
public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	
	
	public Line(){
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.selected = selected;
	}

	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	@Override
	public String toString() {
		return startPoint + " --> " + endPoint;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line temp = (Line) obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}
	
	//ovo
	public double distance(Point p) {
		double distAB = Math.sqrt((getStartPoint().getX() - getEndPoint().getX()) * (getStartPoint().getX() - getEndPoint().getX())
		+ (getStartPoint().getY() - getEndPoint().getY()) * (getStartPoint().getY() - getEndPoint().getY()));
		double distAC = Math.sqrt((getStartPoint().getX() - p.getX()) * (getStartPoint().getX() - p.getX()) + (getStartPoint().getY() - p.getY()) * (getStartPoint().getY() - p.getY()));
		double distBC = Math.sqrt((getEndPoint().getX() - p.getX()) * (getEndPoint().getX() - p.getX()) + (getEndPoint().getY() - p.getY()) * (getEndPoint().getY() - p.getY()));
		double s = (distAB + distAC + distBC) / 2;
		return 2 * (Math.sqrt(s * (s - distAB) * (s - distAC) * (s - distBC))) / distAB;
	}
	
	
	public boolean contains(int x, int y) {
		Point p = new Point(x,y);
		double dfltp = this.distance(p);
		double dfstp = startPoint.distance(p.getX(), p.getY());
		double dfetp = endPoint.distance(p.getX(), p.getY());
		return (dfltp < 5 && dfstp < length() && dfetp < length());
	}
	
	
	
	

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(selected) {
			g.drawRect(getStartPoint().getX() - 3, getStartPoint().getY() - 3, 6, 6);
			g.drawRect(getEndPoint().getX() - 3, getEndPoint().getY() - 3, 6, 6);
		}
		
	}
}