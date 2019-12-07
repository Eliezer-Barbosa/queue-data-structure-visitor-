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

public class PersonFormUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblFirstName, lblLastName, lblPassportNumber, lblPriorityLevel;
	private JTextField tfFirstName, tfLastName, tfPassportNumber;
	private JComboBox<PriorityLevel> cbPriorityLevel;
	private JButton btnCancel, btnAdd;
	private JPanel panelForm, panelButtons;
	private InitialMenuUIController initialMenuUIController;
	
	public PersonFormUI(InitialMenuUIController initialMenuUIController) {
		this.initialMenuUIController = initialMenuUIController;
		setup();
		initComponents();
		buildForm();
		setEvents();
	}
	
	private void setup() {
		this.setTitle("New Person Form");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void initComponents() {
		lblFirstName = new JLabel("First name");
		tfFirstName = new JTextField(30);
		lblLastName = new JLabel("Last name");
		tfLastName = new JTextField(30);
		lblPassportNumber = new JLabel("Passport");
		tfPassportNumber = new JTextField(30);
		lblPriorityLevel = new JLabel("Priority level");
		cbPriorityLevel = new JComboBox<>();
		btnCancel = new JButton("Cancel");
		btnAdd = new JButton("Add");
		panelForm = new JPanel(new GridLayout(4, 1));
		
		for( PriorityLevel priorityLevel : PriorityLevel.values()) { cbPriorityLevel.addItem(priorityLevel); }
		
		panelButtons = new JPanel();
		panelButtons.add(btnAdd);
		panelButtons.add(btnCancel);
		
		panelForm.setBackground(Color.BLACK);
		
		Font font = new Font("Arial", Font.PLAIN, 22);
		
		lblFirstName.setFont(font);
		lblFirstName.setForeground(Color.WHITE);
		lblLastName.setFont(font);
		lblLastName.setForeground(Color.WHITE);
		lblPassportNumber.setFont(font);
		lblPassportNumber.setForeground(Color.WHITE);
		lblPriorityLevel.setFont(font);
		lblPriorityLevel.setForeground(Color.WHITE);
		
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
		panelForm.add(lblPriorityLevel);
		panelForm.add(cbPriorityLevel);
		
		this.add(panelForm, BorderLayout.NORTH);
		this.add(panelButtons);
		this.setVisible(true);
		
	}

	private void setEvents() {
		btnCancel.addActionListener(initialMenuUIController);
		btnCancel.setActionCommand("btnCancel-PersonFormUI");
		
		btnAdd.addActionListener(initialMenuUIController);
		btnAdd.setActionCommand("btnAdd-PersonFormUI");
		
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

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
}
