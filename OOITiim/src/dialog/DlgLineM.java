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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLineM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean commited;
	private JTextField spXField;
	private JTextField spYField;
	private JTextField epXField;
	private JTextField epYField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineM dialog = new DlgLineM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLineM() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Modification for line");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 32, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSP = new JLabel("Start Point");
			lblSP.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_lblSP = new GridBagConstraints();
			gbc_lblSP.insets = new Insets(0, 0, 5, 5);
			gbc_lblSP.gridx = 0;
			gbc_lblSP.gridy = 0;
			contentPanel.add(lblSP, gbc_lblSP);
		}
		{
			JLabel lblSPX = new JLabel("coordinate X:");
			GridBagConstraints gbc_lblSPX = new GridBagConstraints();
			gbc_lblSPX.insets = new Insets(0, 0, 5, 5);
			gbc_lblSPX.anchor = GridBagConstraints.EAST;
			gbc_lblSPX.gridx = 0;
			gbc_lblSPX.gridy = 1;
			contentPanel.add(lblSPX, gbc_lblSPX);
		}
		{
			spXField = new JTextField();
			GridBagConstraints gbc_spXField = new GridBagConstraints();
			gbc_spXField.insets = new Insets(0, 0, 5, 0);
			gbc_spXField.fill = GridBagConstraints.HORIZONTAL;
			gbc_spXField.gridx = 1;
			gbc_spXField.gridy = 1;
			contentPanel.add(spXField, gbc_spXField);
			spXField.setColumns(10);
		}
		{
			JLabel lblspy = new JLabel("coordinate Y:");
			GridBagConstraints gbc_lblspy = new GridBagConstraints();
			gbc_lblspy.anchor = GridBagConstraints.EAST;
			gbc_lblspy.insets = new Insets(0, 0, 5, 5);
			gbc_lblspy.gridx = 0;
			gbc_lblspy.gridy = 2;
			contentPanel.add(lblspy, gbc_lblspy);
		}
		{
			spYField = new JTextField();
			GridBagConstraints gbc_spYField = new GridBagConstraints();
			gbc_spYField.insets = new Insets(0, 0, 5, 0);
			gbc_spYField.fill = GridBagConstraints.HORIZONTAL;
			gbc_spYField.gridx = 1;
			gbc_spYField.gridy = 2;
			contentPanel.add(spYField, gbc_spYField);
			spYField.setColumns(10);
		}
		{
			JLabel lblep = new JLabel("End Point");
			lblep.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_lblep = new GridBagConstraints();
			gbc_lblep.insets = new Insets(0, 0, 5, 5);
			gbc_lblep.gridx = 0;
			gbc_lblep.gridy = 4;
			contentPanel.add(lblep, gbc_lblep);
		}
		{
			JLabel lblepx = new JLabel("coordinate X:");
			GridBagConstraints gbc_lblepx = new GridBagConstraints();
			gbc_lblepx.anchor = GridBagConstraints.EAST;
			gbc_lblepx.insets = new Insets(0, 0, 5, 5);
			gbc_lblepx.gridx = 0;
			gbc_lblepx.gridy = 5;
			contentPanel.add(lblepx, gbc_lblepx);
		}
		{
			epXField = new JTextField();
			GridBagConstraints gbc_epXField = new GridBagConstraints();
			gbc_epXField.insets = new Insets(0, 0, 5, 0);
			gbc_epXField.fill = GridBagConstraints.HORIZONTAL;
			gbc_epXField.gridx = 1;
			gbc_epXField.gridy = 5;
			contentPanel.add(epXField, gbc_epXField);
			epXField.setColumns(10);
		}
		{
			JLabel lblepy = new JLabel("coordinate Y:");
			GridBagConstraints gbc_lblepy = new GridBagConstraints();
			gbc_lblepy.anchor = GridBagConstraints.EAST;
			gbc_lblepy.insets = new Insets(0, 0, 0, 5);
			gbc_lblepy.gridx = 0;
			gbc_lblepy.gridy = 6;
			contentPanel.add(lblepy, gbc_lblepy);
		}
		{
			epYField = new JTextField();
			GridBagConstraints gbc_epYField = new GridBagConstraints();
			gbc_epYField.fill = GridBagConstraints.HORIZONTAL;
			gbc_epYField.gridx = 1;
			gbc_epYField.gridy = 6;
			contentPanel.add(epYField, gbc_epYField);
			epYField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!spXField.getText().isEmpty() && !spYField.getText().isEmpty() 
								&& !epXField.getText().isEmpty() && !epYField.getText().isEmpty()) {
							if(Integer.parseInt(spXField.getText().toString()) > 0 
									&& Integer.parseInt(spYField.getText().toString()) > 0
									&& Integer.parseInt(epXField.getText().toString()) > 0
									&& Integer.parseInt(epYField.getText().toString()) > 0) {
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

	public JTextField getSpXField() {
		return spXField;
	}

	public void setSpXField(JTextField spXField) {
		this.spXField = spXField;
	}

	public JTextField getSpYField() {
		return spYField;
	}

	public void setSpYField(JTextField spYField) {
		this.spYField = spYField;
	}

	public JTextField getEpXField() {
		return epXField;
	}

	public void setEpXField(JTextField epXField) {
		this.epXField = epXField;
	}

	public JTextField getEpYField() {
		return epYField;
	}

	public void setEpYField(JTextField epYField) {
		this.epYField = epYField;
	}

}
