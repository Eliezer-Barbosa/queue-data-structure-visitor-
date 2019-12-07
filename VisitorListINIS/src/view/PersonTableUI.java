package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controller.InitialMenuUIController;
import controller.PersonTableUIMouseController;
import dao.PersonDAO;
import model.DoublyLinkedList;
import model.Person;

public class PersonTableUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PersonDAO personDAO;
	private ArrayList<Person> persons;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private String[] rowData;
	private JPanel panelButtons, infoPanel;
	private JButton btnBack, btnAdd, btnUpdate, btnDelete, btnCallNext, btnDeleteNpersons, btnFindById;
	private InitialMenuUIController initialMenuUIController;
	
	private DoublyLinkedList list;
	
	public PersonTableUI(InitialMenuUIController initialMenuUIController ) {
		this.initialMenuUIController = initialMenuUIController;
		setup();
		initComponents();
		addColumnsName();
		fillUpTable((ArrayList<Person>) persons);
		addButtons();
		if (list.getSize() > 0)
			addInfoPanel();
		setEvents();
	}
	
	private void setup() {
		this.setTitle("Queue of Persons");
		this.setSize(900, 600);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents() {
		list = new DoublyLinkedList();
		personDAO = new PersonDAO();
		persons = personDAO.findAll();
		table = new JTable();
		tableModel = new DefaultTableModel();
		scrollPane = new JScrollPane();
		rowData = new String[100];
		panelButtons = new JPanel(new GridLayout(2, 3));
		btnBack = new JButton("Back");
		btnAdd = new JButton("Add");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnCallNext = new JButton("Call next person");
		btnDeleteNpersons = new JButton("Delete N persons");
		btnFindById = new JButton("Find by ID");
		infoPanel = new JPanel();
		
		Font font = new Font("Arial", Font.PLAIN, 18);
		
		btnBack.setFont(font);
		btnAdd.setFont(font);
		btnUpdate.setFont(font);
		btnDelete.setFont(font);
		btnCallNext.setFont(font);
		btnDeleteNpersons.setFont(font);
		btnFindById.setFont(font);
		
		btnBack.setForeground(Color.WHITE);
		btnAdd.setForeground(Color.WHITE);
		btnUpdate.setForeground(Color.WHITE);
		btnDelete.setForeground(Color.WHITE);
		btnCallNext.setForeground(Color.WHITE);
		btnDeleteNpersons.setForeground(Color.WHITE);
		btnFindById.setForeground(Color.WHITE);
		
		btnBack.setBackground(Color.BLACK);
		btnAdd.setBackground(Color.BLACK);
		btnUpdate.setBackground(Color.BLACK);
		btnDelete.setBackground(Color.BLACK);
		btnCallNext.setBackground(Color.BLACK);
		btnDeleteNpersons.setBackground(Color.BLACK);
		btnFindById.setBackground(Color.BLACK);
		
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		
		table.getTableHeader().setFont(font);
		
	}
	
	private void addColumnsName() {
		tableModel.addColumn("Id");
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Passport");
		tableModel.addColumn("Priority");
	}
	
	private void fillUpTable(ArrayList<Person> persons) {
		
		// here, we are looping through the arrayList of person from the database
		// then, for each person in this arrayList, we are calling the method insertOrdered
		// from the DoublyLinkedList and adding each person in our queue
		for (int i = 0; i < persons.size(); i++) { list.insertOrdered(persons.get(i)); }
	
		for (int i = 0; i < list.getSize(); i++) {
			
			rowData[0] = Integer.toString(list.getNodes().get(i).getId());
			rowData[1] = list.getNodes().get(i).getFirstName();
			rowData[2] = list.getNodes().get(i).getLastName();
			rowData[3] = list.getNodes().get(i).getPassportNumber();
			rowData[4] = list.getNodes().get(i).getPriorityLevel();
			
			tableModel.addRow(rowData);
			table.setModel(tableModel);
			
			Font font = new Font("Arial", Font.PLAIN, 18);
			table.setFont(font);
			table.setRowHeight(30);
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(25);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(2).setPreferredWidth(50);
			columnModel.getColumn(3).setPreferredWidth(50);
			columnModel.getColumn(4).setPreferredWidth(50);
			
			scrollPane.setPreferredSize(new Dimension(800, 400));
			scrollPane.setViewportView(table);
			this.add(scrollPane);
		
		}
		
	}
	
	private void addButtons() {
		panelButtons.add(btnBack);
		panelButtons.add(btnAdd);
		panelButtons.add(btnUpdate);
		panelButtons.add(btnDelete);
		panelButtons.add(btnDeleteNpersons);
		panelButtons.add(btnCallNext);
		panelButtons.add(btnFindById);
		
		this.add(panelButtons);
	}
	
	private void addInfoPanel() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 25);

		JLabel head = new JLabel("HEAD");
		JLabel headResponse = new JLabel("head response");
		
		JLabel tail = new JLabel("TAIL");
		JLabel tailResponse = new JLabel("tail response");
		
		headResponse.setText(list.getHead().getFirstName());
		tailResponse.setText(list.getTail().getFirstName());
		headResponse.setFont(font);
		tailResponse.setFont(font);
		
		headResponse.setForeground(Color.BLUE);
		tailResponse.setForeground(Color.RED);
		
		infoPanel.add(head);
		infoPanel.add(headResponse);
		infoPanel.add(tail);
		infoPanel.add(tailResponse);
		this.add(infoPanel);
	}
	
	private void setEvents() {
		btnBack.addActionListener(initialMenuUIController);
		btnBack.setActionCommand("btnBack-PersonTableUI");
		btnBack.addMouseListener(new PersonTableUIMouseController(this));
		
		btnAdd.addActionListener(initialMenuUIController);
		btnAdd.setActionCommand("btnAdd-PersonTableUI");
		btnAdd.addMouseListener(new PersonTableUIMouseController(this));
		
		btnUpdate.addActionListener(initialMenuUIController);
		btnUpdate.setActionCommand("btnUpdate-PersonTableUI");
		btnUpdate.addMouseListener(new PersonTableUIMouseController(this));
		
		btnDelete.addActionListener(initialMenuUIController);
		btnDelete.setActionCommand("btnDelete-PersonTableUI");
		btnDelete.addMouseListener(new PersonTableUIMouseController(this));
		
		btnCallNext.addActionListener(initialMenuUIController);
		btnCallNext.setActionCommand("btnCallNext-PersonTableUI");
		btnCallNext.addMouseListener(new PersonTableUIMouseController(this));
		
		btnDeleteNpersons.addActionListener(initialMenuUIController);
		btnDeleteNpersons.setActionCommand("btnDeleteNpersons-PersonTableUI");
		btnDeleteNpersons.addMouseListener(new PersonTableUIMouseController(this));
		
		btnFindById.addActionListener(initialMenuUIController);
		btnFindById.setActionCommand("btnFindById-PersonTableUI");
		btnFindById.addMouseListener(new PersonTableUIMouseController(this));
		
	}
	
	public JTable getTable() {
		return table;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnCallNext() {
		return btnCallNext;
	}

	public JButton getBtnDeleteNpersons() {
		return btnDeleteNpersons;
	}

	public JButton getBtnFindById() {
		return btnFindById;
	}

}
