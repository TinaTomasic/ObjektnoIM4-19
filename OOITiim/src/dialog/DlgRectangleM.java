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

public class DlgRectangleM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean commited;
	private JTextField widthField;
	private JTextField heightField;
	private JTextField upperXField;
	private JTextField upperYField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleM dialog = new DlgRectangleM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleM() {
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
			JLabel lblWidth = new JLabel("width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 0;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			widthField = new JTextField();
			GridBagConstraints gbc_widthField = new GridBagConstraints();
			gbc_widthField.insets = new Insets(0, 0, 5, 0);
			gbc_widthField.fill = GridBagConstraints.HORIZONTAL;
			gbc_widthField.gridx = 1;
			gbc_widthField.gridy = 0;
			contentPanel.add(widthField, gbc_widthField);
			widthField.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 1;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			heightField = new JTextField();
			GridBagConstraints gbc_heightField = new GridBagConstraints();
			gbc_heightField.insets = new Insets(0, 0, 5, 0);
			gbc_heightField.fill = GridBagConstraints.HORIZONTAL;
			gbc_heightField.gridx = 1;
			gbc_heightField.gridy = 1;
			contentPanel.add(heightField, gbc_heightField);
			heightField.setColumns(10);
		}
		{
			JLabel lblUpperLeftPointX = new JLabel("coordinate X:");
			GridBagConstraints gbc_lblUpperLeftPointX = new GridBagConstraints();
			gbc_lblUpperLeftPointX.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeftPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftPointX.gridx = 0;
			gbc_lblUpperLeftPointX.gridy = 2;
			contentPanel.add(lblUpperLeftPointX, gbc_lblUpperLeftPointX);
		}
		{
			upperXField = new JTextField();
			GridBagConstraints gbc_upperXField = new GridBagConstraints();
			gbc_upperXField.insets = new Insets(0, 0, 5, 0);
			gbc_upperXField.fill = GridBagConstraints.HORIZONTAL;
			gbc_upperXField.gridx = 1;
			gbc_upperXField.gridy = 2;
			contentPanel.add(upperXField, gbc_upperXField);
			upperXField.setColumns(10);
		}
		{
			JLabel lblUpperLeftPointY = new JLabel("coordinate Y:");
			GridBagConstraints gbc_lblUpperLeftPointY = new GridBagConstraints();
			gbc_lblUpperLeftPointY.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeftPointY.insets = new Insets(0, 0, 0, 5);
			gbc_lblUpperLeftPointY.gridx = 0;
			gbc_lblUpperLeftPointY.gridy = 3;
			contentPanel.add(lblUpperLeftPointY, gbc_lblUpperLeftPointY);
		}
		{
			upperYField = new JTextField();
			GridBagConstraints gbc_upperYField = new GridBagConstraints();
			gbc_upperYField.fill = GridBagConstraints.HORIZONTAL;
			gbc_upperYField.gridx = 1;
			gbc_upperYField.gridy = 3;
			contentPanel.add(upperYField, gbc_upperYField);
			upperYField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!widthField.getText().isEmpty() && !heightField.getText().isEmpty() 
								&& !upperXField.getText().isEmpty() && !upperYField.getText().isEmpty()) {
							if(Integer.parseInt(widthField.getText().toString()) > 0 && 
									Integer.parseInt(heightField.getText().toString()) > 0
									&& Integer.parseInt(upperXField.getText().toString()) > 0
									&& Integer.parseInt(upperYField .getText().toString()) > 0) {
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

	public JTextField getWidthField() {
		return widthField;
	}

	public void setWidthField(JTextField widthField) {
		this.widthField = widthField;
	}

	public JTextField getHeightField() {
		return heightField;
	}

	public void setHeightField(JTextField heightField) {
		this.heightField = heightField;
	}

	public JTextField getUpperXField() {
		return upperXField;
	}

	public void setUpperXField(JTextField upperXField) {
		this.upperXField = upperXField;
	}

	public JTextField getUpperYField() {
		return upperYField;
	}

	public void setUpperYField(JTextField upperYField) {
		this.upperYField = upperYField;
	}
	

}
