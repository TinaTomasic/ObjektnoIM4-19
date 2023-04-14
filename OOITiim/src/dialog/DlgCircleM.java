package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircleM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean commited;
	private JTextField rField;
	private JTextField centerXField;
	private JTextField centerYField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircleM dialog = new DlgCircleM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircleM() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Modification for cicle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRadiusM = new JLabel("radius:");
			GridBagConstraints gbc_lblRadiusM = new GridBagConstraints();
			gbc_lblRadiusM.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadiusM.anchor = GridBagConstraints.EAST;
			gbc_lblRadiusM.gridx = 0;
			gbc_lblRadiusM.gridy = 0;
			contentPanel.add(lblRadiusM, gbc_lblRadiusM);
		}
		{
			rField = new JTextField();
			GridBagConstraints gbc_rField = new GridBagConstraints();
			gbc_rField.insets = new Insets(0, 0, 5, 0);
			gbc_rField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rField.gridx = 1;
			gbc_rField.gridy = 0;
			contentPanel.add(rField, gbc_rField);
			rField.setColumns(10);
		}
		{
			JLabel lblCoordinateX = new JLabel("coordinate X:");
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 0;
			gbc_lblCoordinateX.gridy = 1;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			centerXField = new JTextField();
			GridBagConstraints gbc_centerXField = new GridBagConstraints();
			gbc_centerXField.insets = new Insets(0, 0, 5, 0);
			gbc_centerXField.fill = GridBagConstraints.HORIZONTAL;
			gbc_centerXField.gridx = 1;
			gbc_centerXField.gridy = 1;
			contentPanel.add(centerXField, gbc_centerXField);
			centerXField.setColumns(10);
		}
		{
			JLabel lblCoordinateY = new JLabel("coordinate Y:");
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateY.insets = new Insets(0, 0, 0, 5);
			gbc_lblCoordinateY.gridx = 0;
			gbc_lblCoordinateY.gridy = 2;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			centerYField = new JTextField();
			GridBagConstraints gbc_centerYField = new GridBagConstraints();
			gbc_centerYField.fill = GridBagConstraints.HORIZONTAL;
			gbc_centerYField.gridx = 1;
			gbc_centerYField.gridy = 2;
			contentPanel.add(centerYField, gbc_centerYField);
			centerYField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!rField.getText().isEmpty() && !centerXField.getText().isEmpty() && !centerYField.getText().isEmpty()) {
							if(Integer.parseInt(rField.getText().toString()) > 0 && Integer.parseInt(centerXField.getText().toString()) > 0
									&& Integer.parseInt(centerYField.getText().toString()) > 0) {
								setCommited(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "You have to enter values greather than 0!", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "You have to enter all fields!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setCommited(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
	}

	public JTextField getrField() {
		return rField;
	}

	public void setrField(JTextField rField) {
		this.rField = rField;
	}

	public JTextField getCenterXField() {
		return centerXField;
	}

	public void setCenterXField(JTextField centerXField) {
		this.centerXField = centerXField;
	}

	public JTextField getCenterYField() {
		return centerYField;
	}

	public void setCenterYField(JTextField centerYField) {
		this.centerYField = centerYField;
	}
	

}
