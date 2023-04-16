package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialog.DlgRectangleM;

import javax.swing.JToolBar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		JButton btnAdd = new JButton("Add Rectangle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangleM dlgRect = new DlgRectangleM();
				dlgRect.setVisible(true);
			}
		});
		btnAdd.setBounds(85, 309, 140, 23);
		contentPane.add(btnAdd);
		buttonGroup.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove Rectangle");
		btnRemove.setBounds(298, 309, 156, 23);
		contentPane.add(btnRemove);
		buttonGroup.add(btnRemove);
		
		
		
	}
}
