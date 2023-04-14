package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inRField;
	private JTextField outRField;
	private boolean commited;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Donut");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		{
			JLabel lblInR = new JLabel("inner radius:");
			GridBagConstraints gbc_lblInR = new GridBagConstraints();
			gbc_lblInR.anchor = GridBagConstraints.EAST;
			gbc_lblInR.insets = new Insets(0, 0, 5, 5);
			gbc_lblInR.gridx = 0;
			gbc_lblInR.gridy = 1;
			contentPanel.add(lblInR, gbc_lblInR);
		}
		{
			inRField = new JTextField();
			GridBagConstraints gbc_inRField = new GridBagConstraints();
			gbc_inRField.insets = new Insets(0, 0, 5, 0);
			gbc_inRField.fill = GridBagConstraints.HORIZONTAL;
			gbc_inRField.gridx = 1;
			gbc_inRField.gridy = 1;
			contentPanel.add(inRField, gbc_inRField);
			inRField.setColumns(10);
		}
		{
			JLabel lblOutR = new JLabel("outer radius:");
			GridBagConstraints gbc_lblOutR = new GridBagConstraints();
			gbc_lblOutR.anchor = GridBagConstraints.EAST;
			gbc_lblOutR.insets = new Insets(0, 0, 5, 5);
			gbc_lblOutR.gridx = 0;
			gbc_lblOutR.gridy = 2;
			contentPanel.add(lblOutR, gbc_lblOutR);
		}
		{
			outRField = new JTextField();
			GridBagConstraints gbc_outRField = new GridBagConstraints();
			gbc_outRField.insets = new Insets(0, 0, 5, 0);
			gbc_outRField.fill = GridBagConstraints.HORIZONTAL;
			gbc_outRField.gridx = 1;
			gbc_outRField.gridy = 2;
			contentPanel.add(outRField, gbc_outRField);
			inRField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!inRField.getText().isEmpty() && !outRField.getText().isEmpty()) {
							if(Integer.parseInt(inRField.getText().toString()) > 0 && 
									Integer.parseInt(outRField.getText().toString()) > 0) {
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
	

}
