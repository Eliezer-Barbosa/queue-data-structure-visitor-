package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.InitialMenuUIController;
import controller.InitialMenuUIMouseController;

public class InitialMenuUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton btnDisplayQueue, btnAddPerson, btnDeletePerson, btnUpdatePerson;
	private InitialMenuUIController initialMenuUIController;
	
	public InitialMenuUI(InitialMenuUIController initialMenuUIController) {
		this.initialMenuUIController = initialMenuUIController;
		setup();
		initComponents();
		addComponentsToFrame();
		setEvents();
		
		this.setVisible(true);
	}
	
	private void setup() {
		this.setTitle("Immigration Control Queue System");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 1));
		this.setLocationRelativeTo(null);
	}
	
	private void initComponents() {
		btnDisplayQueue = new JButton("Display Queue");
		btnAddPerson = new JButton("Add Person");
		btnDeletePerson = new JButton("Delete Person");
		btnUpdatePerson = new JButton("Update Person");
		
		Font font = new Font("Arial",  Font.PLAIN, 26);
		
		btnDisplayQueue.setFont(font);
		btnAddPerson.setFont(font);
		btnDeletePerson.setFont(font);
		btnUpdatePerson.setFont(font);
		
		btnDisplayQueue.setForeground(Color.WHITE);
		btnAddPerson.setForeground(Color.WHITE);
		btnDeletePerson.setForeground(Color.WHITE);
		btnUpdatePerson.setForeground(Color.WHITE);
		
		btnDisplayQueue.setBackground(Color.BLACK);
		btnAddPerson.setBackground(Color.BLACK);
		btnDeletePerson.setBackground(Color.BLACK);
		btnUpdatePerson.setBackground(Color.BLACK);
	}
	
	private void addComponentsToFrame() {
		this.add(btnDisplayQueue);
		this.add(btnAddPerson);
		this.add(btnDeletePerson);
		this.add(btnUpdatePerson);
	}
	
	private void setEvents() {
		btnDisplayQueue.addActionListener(initialMenuUIController);
		btnDisplayQueue.setActionCommand("btnDisplayQueue-InitialMenuUI");
		btnDisplayQueue.addMouseListener(new InitialMenuUIMouseController(this));
		
		btnAddPerson.addActionListener(initialMenuUIController);
		btnAddPerson.setActionCommand("btnAddPerson-InitialMenuUI");
		btnAddPerson.addMouseListener(new InitialMenuUIMouseController(this));
		
		btnDeletePerson.addActionListener(initialMenuUIController);
		btnDeletePerson.setActionCommand("btnDeletePerson-InitialMenuUI");
		btnDeletePerson.addMouseListener(new InitialMenuUIMouseController(this));
		
		btnUpdatePerson.addActionListener(initialMenuUIController);
		btnUpdatePerson.setActionCommand("btnUpdatePerson-InitialMenuUI");
		btnUpdatePerson.addMouseListener(new InitialMenuUIMouseController(this));
	}

	public JButton getBtnDisplayQueue() {
		return btnDisplayQueue;
	}

	public JButton getBtnAddPerson() {
		return btnAddPerson;
	}

	public JButton getBtnDeletePerson() {
		return btnDeletePerson;
	}

	public JButton getBtnUpdatePerson() {
		return btnUpdatePerson;
	}

}

