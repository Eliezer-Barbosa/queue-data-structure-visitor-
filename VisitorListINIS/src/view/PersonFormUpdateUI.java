package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.InitialMenuUIController;
import model.enums.PriorityLevel;

public class PersonFormUpdateUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblFirstName, lblLastName, lblPassportNumber, lblPriority;
	private JTextField tfFirstName, tfLastName, tfPassportNumber;
	private JComboBox<PriorityLevel> cbPriorityLevel;
	private JButton btnUpdate, btnCancel;
	private JPanel panelForm, panelButtons;
	private String idToUpdate, previousFirstName, previousLastName, previousPassport;
	
	private InitialMenuUIController initialMenuUIController;
	
	public PersonFormUpdateUI(InitialMenuUIController initialMenuUIController) {
		this.initialMenuUIController = initialMenuUIController;
		setup();
		initComponents();
		buildForm();
		setEvents();
	}
	
	private void setup() {
		this.setTitle("Update Person Form");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents() {
		lblFirstName = new JLabel("First Name");
		lblLastName = new JLabel("Last Name");
		lblPassportNumber = new JLabel("Passport");
		lblPriority = new JLabel("Priority");
		tfFirstName = new JTextField(30);
		tfLastName = new JTextField(30);
		tfPassportNumber = new JTextField(30);
		cbPriorityLevel = new JComboBox<>();
		btnUpdate = new JButton("Update");
		btnCancel = new JButton("Cancel");
		panelForm = new JPanel(new GridLayout(6, 2));
		
		for(PriorityLevel level : PriorityLevel.values()) { cbPriorityLevel.addItem(level); }
		
		//panelForm = new JPanel();
		panelButtons = new JPanel();
		panelButtons.add(btnUpdate);
		panelButtons.add(btnCancel);
		
		panelForm.setBackground(Color.BLACK);
		
		Font font = new Font("Arial", Font.PLAIN, 22);
		
		lblFirstName.setFont(font);
		lblFirstName.setForeground(Color.WHITE);
		lblLastName.setFont(font);
		lblLastName.setForeground(Color.WHITE);
		lblPassportNumber.setFont(font);
		lblPassportNumber.setForeground(Color.WHITE);
		lblPriority.setFont(font);
		lblPriority.setForeground(Color.WHITE);
		
		tfFirstName.setFont(font);
		tfLastName.setFont(font);
		tfPassportNumber.setFont(font);
		
		cbPriorityLevel.setForeground(Color.WHITE);
		cbPriorityLevel.setBackground(Color.BLACK);
	}
	
	private void buildForm() {
		panelForm.add(lblFirstName);
		panelForm.add(tfFirstName);
		panelForm.add(lblLastName);
		panelForm.add(tfLastName);
		panelForm.add(lblPassportNumber);
		panelForm.add(tfPassportNumber);
		panelForm.add(lblPriority);
		panelForm.add(cbPriorityLevel);
		
		this.add(panelForm, BorderLayout.NORTH);
		this.add(panelButtons);
	}
	
	private void setEvents() {
		btnCancel.addActionListener(initialMenuUIController);
		btnCancel.setActionCommand("btnCancel-PersonFormUpdateUI");
		
		btnUpdate.addActionListener(initialMenuUIController);
		btnUpdate.setActionCommand("btnUpdate-PersonFormUpdate");
	}

	public JLabel getLblFirstName() {
		return lblFirstName;
	}

	public JLabel getLblLastName() {
		return lblLastName;
	}

	public JLabel getLblPassportNumber() {
		return lblPassportNumber;
	}

	public JLabel getLblPriority() {
		return lblPriority;
	}

	public JTextField getTfFirstName() {
		return tfFirstName;
	}

	public JTextField getTfLastName() {
		return tfLastName;
	}

	public JTextField getTfPassportNumber() {
		return tfPassportNumber;
	}

	public JComboBox<PriorityLevel> getCbPriorityLevel() {
		return cbPriorityLevel;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public String getIdToUpdate() {
		return idToUpdate;
	}

	public String getPreviousFirstName() {
		return previousFirstName;
	}

	public void setIdToUpdate(String id) {
		this.idToUpdate = id;
	}

	public void setPreviousFirstName(String previousFirstName) {
		this.previousFirstName = previousFirstName;
	}

	public String getPreviousLastName() {
		return previousLastName;
	}

	public void setPreviousLastName(String previousLastName) {
		this.previousLastName = previousLastName;
	}

	public String getPreviousPassport() {
		return previousPassport;
	}

	public void setPreviousPassport(String previousPassport) {
		this.previousPassport = previousPassport;
	}
	
}

