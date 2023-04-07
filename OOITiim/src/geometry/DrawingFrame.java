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
import dialog.DlgDonut;
import dialog.DlgRectangle;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private Drawing drawingPanel;
	private ArrayList<Shape> slctd = new ArrayList<Shape>();
	private boolean selected;
	private Color clr;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton btnLine;
	private int counter = 0;
	private Point startPoint, endPoint, upperLeft, center;
	private JToggleButton btnRectangle;
	private JToggleButton btnCircle;
	private JToggleButton btnColor;
	private JToggleButton btnSelect;

	

	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
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
		btnRectangle.setBounds(162, 490, 94, 23);
		buttonGroup.add(btnRectangle);
		contentPane.add(btnRectangle);
		
		btnCircle = new JToggleButton("Circle");
		btnCircle.setBounds(253, 490, 82, 23);
		buttonGroup.add(btnCircle);
		contentPane.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		btnDonut.setBounds(334, 490, 82, 23);
		buttonGroup.add(btnDonut);
		contentPane.add(btnDonut);
		
		btnColor = new JToggleButton("Color");
		btnColor.addActionListener(new ActionListener() {
			//coloring
			public void actionPerformed(ActionEvent e) {
				
				for(Shape s : slctd) {
					clr = JColorChooser.showDialog(null, "Choose the color:",Color.BLACK);
					if(s instanceof Point){
							repaint();
							s.setColor(clr);
							repaint();
					}else if(s instanceof Line) {
							repaint();
							s.setColor(clr);
							repaint();
					}else if(s instanceof Rectangle) {
							repaint();
							s.setColor(clr);
							repaint();
					}else if(s instanceof Circle) {
						if(s.getClass() != Circle.class) {
							repaint();
							s.setColor(clr);
							repaint();
						}else {
							repaint();
							s.setColor(clr);
							repaint();
						}		
					}}
			}
		});
		btnColor.setBounds(414, 490, 82, 23);
		contentPane.add(btnColor);
		buttonGroup.add(btnColor);
		
		btnSelect = new JToggleButton("Select");
		btnSelect.setBounds(496, 490, 82, 23);
		contentPane.add(btnSelect);
		buttonGroup.add(btnSelect);
		
		JToggleButton btnModify = new JToggleButton("Modify");
		btnModify.setBounds(576, 490, 82, 23);
		contentPane.add(btnModify);
		buttonGroup.add(btnModify);
		
		JToggleButton btnErase = new JToggleButton("Erase");
		btnErase.setBounds(656, 490, 94, 23);
		contentPane.add(btnErase);
		buttonGroup.add(btnErase);
		
		
		//drawing
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
					
				}else if (btnDonut.isSelected()){
					center = new Point(e.getX(),e.getY());
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setVisible(true);
					if(dlgDonut.isCommited()) {
						int innerR = Integer.parseInt(dlgDonut.getInRField().getText());
						int r = Integer.parseInt(dlgDonut.getOutRField().getText());
						Donut d = new Donut(center, r, innerR);
						drawingPanel.getShapes().add(d);
						repaint();
						}
					} else if(btnSelect.isSelected()){
						selected(e);
					}
				
			}
			//to select
			private void selected(MouseEvent e) {
				for(Shape s : drawingPanel.getShapes()) {
					if(s.contains(e.getX(), e.getY())){
						if(s instanceof Point) {
							if(!s.isSelected()) {
								s.setSelected(true);
								slctd.add(s);
								repaint();
							}else {
								s.setSelected(false);
								slctd.remove(s);
								repaint();
							}
						} else if(s instanceof Line) {
							if(!s.isSelected()) {
								s.setSelected(true);
								slctd.add(s);
								repaint();
							}else {
								s.setSelected(false);
								slctd.remove(s);
								repaint();
							}
						}else if(s instanceof Rectangle) {
							if(!s.isSelected()) {
								s.setSelected(true);
								slctd.add(s);
								repaint();
							}else {
								s.setSelected(false);
								slctd.remove(s);
								repaint();
							}
						}else if(s instanceof Circle) {
							if(s.getClass() != Circle.class) {
								if(!s.isSelected()) {
									s.setSelected(true);
									slctd.add(s);
									repaint();
								}else {
									s.setSelected(false);
									slctd.remove(s);
									repaint();
								}
							}else {
								if(!s.isSelected()) {
									s.setSelected(true);
									slctd.add(s);
									repaint();
								}else {
									s.setSelected(false);
									slctd.remove(s);
									repaint();
								}
							}
						}
						
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
