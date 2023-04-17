package stackAndSort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialog.DlgRectangle;
import dialog.DlgRectangleM;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.JToolBar;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Stack<Rectangle> stack = new Stack<Rectangle>();
	private Rectangle pravougaonik;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 560, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel stackPanel = new JPanel();
		stackPanel.setBounds(0, 11, 536, 290);
		contentPane.add(stackPanel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		stackPanel.add(textArea);
		textArea.setBounds(0, 11, 536, 290);
		
		JButton btnAdd = new JButton("Add Rectangle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangle dlgRect = new DlgRectangle();
				dlgRect.setVisible(true);
				Point upperLeft = new Point();
				int width = Integer.parseInt(dlgRect.getWidthField().getText());
				int height = Integer.parseInt(dlgRect.getHeightField().getText());
				pravougaonik = new Rectangle(upperLeft, width, height);
						
				if(dlgRect.isCommited()) {
					stack.push(pravougaonik);
					//System.out.println(stack);
					String stackString = stack.toString();
		            textArea.setText(stackString);
					
		         
					
				}
				
				
			}
		});
		btnAdd.setBounds(74, 309, 140, 23);
		contentPane.add(btnAdd);
		buttonGroup.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove Rectangle");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(stack.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The stack is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					Rectangle prom = stack.pop();
					//System.out.println(stack);
					String stackString = stack.toString();
		            textArea.setText(stackString);
					}
				}
		
				
			});
		
		
		btnRemove.setBounds(323, 309, 156, 23);
		contentPane.add(btnRemove);
		buttonGroup.add(btnRemove);
		
		JButton btnSort = new JButton("Sort ASC");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!stack.isEmpty()) {
			        Rectangle[] rectArray = stack.toArray(new Rectangle[stack.size()]);
			        Arrays.sort(rectArray, new Comparator<Rectangle>() {
			            public int compare(Rectangle rect1, Rectangle rect2) {
			                int area1 = rect1.getWidth() * rect1.getHeight();
			                int area2 = rect2.getWidth() * rect2.getHeight();
			                return area1 - area2;
			            }
			        });
			        stack.clear();
			        for (Rectangle rect : rectArray) {
			            stack.push(rect);
			        }
			        String stackString = stack.toString();
			        textArea.setText(stackString);
				}
				
			}
		});
		btnSort.setBounds(224, 309, 89, 23);
		contentPane.add(btnSort);
		
		
		
	}
}
