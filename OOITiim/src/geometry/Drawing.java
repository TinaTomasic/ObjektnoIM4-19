package geometry;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;



public class Drawing extends JPanel {

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
		
	}	
	public Drawing() {
		
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

	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}

}
