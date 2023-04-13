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

public class DlgDonutM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inRField;
	private JTextField outRField;
	private boolean commited;
	private JTextField centerXField;
	private JTextField centerYField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutM dialog = new DlgDonutM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutM() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblInnerradius = new JLabel("inner radius:");
			GridBagConstraints gbc_lblInnerradius = new GridBagConstraints();
			gbc_lblInnerradius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerradius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerradius.gridx = 0;
			gbc_lblInnerradius.gridy = 0;
			contentPanel.add(lblInnerradius, gbc_lblInnerradius);
		}
		{
			inRField = new JTextField();
			GridBagConstraints gbc_inRField = new GridBagConstraints();
			gbc_inRField.insets = new Insets(0, 0, 5, 0);
			gbc_inRField.fill = GridBagConstraints.HORIZONTAL;
			gbc_inRField.gridx = 1;
			gbc_inRField.gridy = 0;
			contentPanel.add(inRField, gbc_inRField);
			inRField.setColumns(10);
		}
		{
			JLabel lblOutr = new JLabel("outer radius:");
			GridBagConstraints gbc_lblOutr = new GridBagConstraints();
			gbc_lblOutr.anchor = GridBagConstraints.EAST;
			gbc_lblOutr.insets = new Insets(0, 0, 5, 5);
			gbc_lblOutr.gridx = 0;
			gbc_lblOutr.gridy = 1;
			contentPanel.add(lblOutr, gbc_lblOutr);
		}
		{
			outRField = new JTextField();
			GridBagConstraints gbc_outRField = new GridBagConstraints();
			gbc_outRField.insets = new Insets(0, 0, 5, 0);
			gbc_outRField.fill = GridBagConstraints.HORIZONTAL;
			gbc_outRField.gridx = 1;
			gbc_outRField.gridy = 1;
			contentPanel.add(outRField, gbc_outRField);
			outRField.setColumns(10);
		}
		{
			JLabel lblcoordinateX = new JLabel("coordinate X:");
			GridBagConstraints gbc_lblcoordinateX = new GridBagConstraints();
			gbc_lblcoordinateX.anchor = GridBagConstraints.EAST;
			gbc_lblcoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblcoordinateX.gridx = 0;
			gbc_lblcoordinateX.gridy = 2;
			contentPanel.add(lblcoordinateX, gbc_lblcoordinateX);
		}
		{
			centerXField = new JTextField();
			GridBagConstraints gbc_centerXField = new GridBagConstraints();
			gbc_centerXField.insets = new Insets(0, 0, 5, 0);
			gbc_centerXField.fill = GridBagConstraints.HORIZONTAL;
			gbc_centerXField.gridx = 1;
			gbc_centerXField.gridy = 2;
			contentPanel.add(centerXField, gbc_centerXField);
			centerXField.setColumns(10);
		}
		{
			JLabel lblcoordinateY = new JLabel("coordinate Y:");
			GridBagConstraints gbc_lblcoordinateY = new GridBagConstraints();
			gbc_lblcoordinateY.anchor = GridBagConstraints.EAST;
			gbc_lblcoordinateY.insets = new Insets(0, 0, 0, 5);
			gbc_lblcoordinateY.gridx = 0;
			gbc_lblcoordinateY.gridy = 3;
			contentPanel.add(lblcoordinateY, gbc_lblcoordinateY);
		}
		{
			centerYField = new JTextField();
			GridBagConstraints gbc_centerYField = new GridBagConstraints();
			gbc_centerYField.fill = GridBagConstraints.HORIZONTAL;
			gbc_centerYField.gridx = 1;
			gbc_centerYField.gridy = 3;
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
						if(!inRField.getText().isEmpty() && !outRField.getText().isEmpty() 
								&& !centerXField.getText().isEmpty() && !centerYField.getText().isEmpty()) {
							if(Integer.parseInt(inRField.getText().toString()) > 0 
									&& Integer.parseInt(outRField.getText().toString()) > 0
									&& Integer.parseInt(centerXField.getText().toString()) > 0
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

	public JTextField getInRField() {
		return inRField;
	}

	public void setInRField(JTextField inRField) {
		this.inRField = inRField;
	}

	public JTextField getOutRField() {
		return outRField;
	}

	public void setOutRField(JTextField outRField) {
		this.outRField = outRField;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
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
