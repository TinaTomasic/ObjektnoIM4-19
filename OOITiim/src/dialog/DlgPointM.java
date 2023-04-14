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

public class DlgPointM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean commited;
	private JTextField xField;
	private JTextField yField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPointM dialog = new DlgPointM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPointM() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Modification for point");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("coordinate X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			xField = new JTextField();
			GridBagConstraints gbc_xField = new GridBagConstraints();
			gbc_xField.insets = new Insets(0, 0, 5, 0);
			gbc_xField.fill = GridBagConstraints.HORIZONTAL;
			gbc_xField.gridx = 1;
			gbc_xField.gridy = 0;
			contentPanel.add(xField, gbc_xField);
			xField.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("coordinate Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 0, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			yField = new JTextField();
			GridBagConstraints gbc_yField = new GridBagConstraints();
			gbc_yField.fill = GridBagConstraints.HORIZONTAL;
			gbc_yField.gridx = 1;
			gbc_yField.gridy = 1;
			contentPanel.add(yField, gbc_yField);
			yField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!xField.getText().isEmpty() && !yField.getText().isEmpty()) {
							if(Integer.parseInt(xField.getText().toString()) > 0 && Integer.parseInt(yField.getText().toString()) > 0) {
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

	public JTextField getxField() {
		return xField;
	}

	public void setxField(JTextField xField) {
		this.xField = xField;
	}

	public JTextField getyField() {
		return yField;
	}

	public void setyField(JTextField yField) {
		this.yField = yField;
	}
	

}
