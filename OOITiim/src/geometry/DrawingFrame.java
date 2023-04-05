package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dialog.DlgCircle;
import dialog.DlgRectangle;

import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private Drawing drawingPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton btnLine;
	private int counter = 0;
	private Point startPoint, endPoint, upperLeft, center;
	private JToggleButton btnRectangle;
	private JToggleButton btnCircle;
	

	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 550);
		contentPane = new JPanel();
		drawingPanel = new Drawing();
		drawingPanel.setBounds(0, 0, 826, 490);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnPoint = new JToggleButton("Point");
		btnPoint.setBounds(0, 490, 82, 23);
		contentPane.add(btnPoint);
		buttonGroup.add(btnPoint);
		drawingPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(drawingPanel);
		contentPane.add(btnPoint, BorderLayout.SOUTH);
		drawingPanel.setLayout(null);
		
		btnLine = new JToggleButton("Line");
		btnLine.setBounds(81, 490, 82, 23);
		buttonGroup.add(btnLine);
		contentPane.add(btnLine);
		
		btnRectangle = new JToggleButton("Rectangle");
		btnRectangle.setBounds(162, 490, 98, 23);
		buttonGroup.add(btnRectangle);
		contentPane.add(btnRectangle);
		
		btnCircle = new JToggleButton("Circle");
		btnCircle.setBounds(257, 490, 123, 23);
		buttonGroup.add(btnCircle);
		contentPane.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		btnDonut.setBounds(380, 490, 123, 23);
		buttonGroup.add(btnDonut);
		contentPane.add(btnDonut);
		
		
		
		drawingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnPoint.isSelected()) {
					Point p = new Point(e.getX(),e.getY());
					drawingPanel.getShapes().add(p);
					repaint();
				}else if(btnLine.isSelected()) {
					counter++;
					if(counter == 1) {
						startPoint = new Point(e.getX(), e.getY());
					}else if(counter == 2){
						endPoint = new Point(e.getX(),e.getY());
						Line l = new Line(startPoint, endPoint);
						drawingPanel.getShapes().add(l);
						repaint();
						counter = 0;
					}
				}else if(btnRectangle.isSelected()) {
					upperLeft = new Point(e.getX(),e.getY());
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setVisible(true);
					if(dlgRectangle.isCommited()) {
						int width = Integer.parseInt(dlgRectangle.getWidthField().getText());
						int height = Integer.parseInt(dlgRectangle.getHeightField().getText());
						Rectangle r = new Rectangle(upperLeft, width, height);
						drawingPanel.getShapes().add(r);
						repaint();
						
					}
				}else if (btnCircle.isSelected()) {
					center = new Point(e.getX(),e.getY());
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setVisible(true);
					if(dlgCircle.isCommited()) {
						int r = Integer.parseInt(dlgCircle.getRField().getText());
						Circle c = new Circle(center, r);
						drawingPanel.getShapes().add(c);
						repaint();
					}
					
				} 
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
