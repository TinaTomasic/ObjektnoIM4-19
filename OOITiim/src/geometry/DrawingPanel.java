package geometry;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape selected;
	
	public DrawingPanel() {
		

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s: shapes) {
			if(s.isSelected())
			{
				g.setColor(s.getColor());
				s.draw(g);
			}
			else {
				g.setColor(s.getColor());
				s.draw(g);
			}
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public Shape getSelected() {
		return selected;
	}
	
	
	
	

}
