package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import dao.PersonDAO;
import model.DoublyLinkedList;
import model.Node;
import model.Person;
import model.enums.PriorityLevel;
import view.InitialMenuUI;
import view.PersonFormUI;
import view.PersonFormUpdateUI;
import view.PersonTableUI;


/**
 * @author Eliezer
 * 
 * Class responsible of event handling, getting all buttons actions.
 * 
 */
public class InitialMenuUIController implements ActionListener {
	
	/*
	 * Declaration of variables that is going to be used through this class
	 * 
	 * **/
	private InitialMenuUI initialMenuUI;
	private PersonTableUI personTableUI;
	private PersonFormUI personFormUI;
	private PersonFormUpdateUI personFormUpdateUI;
	
	private PersonDAO personDAO;;
	private Person person;
	
	private DoublyLinkedList list;
	
	public InitialMenuUIController() {
		this.initialMenuUI = new InitialMenuUI(this);
		this.list = new DoublyLinkedList();
	}
	
	/*
	 * Method responsible of getting the action from a specific button, according to its action command.
	 * **/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("btnDisplayQueue-InitialMenuUI")) {
			closeInitialMenu();
			showPersons();
		} 
		
		else if(e.getActionCommand().equals("btnBack-PersonTableUI")) {
				personTableUI.setVisible(false);
				initialMenuUI.setVisible(true);
		}
		
		else if(e.getActionCommand().equals("btnAdd-PersonTableUI")) {
			this.personTableUI.setVisible(false);
			showPersonForm();
		}
		
		else if(e.getActionCommand().equals("btnCancel-PersonFormUI")) {
			this.personFormUI.setVisible(false);
			showPersons();
			personTableUI.setVisible(true);
		}
		
		else if(e.getActionCommand().equals("btnAdd-PersonFormUI")) {
			addNewPerson();
		}
		
		else if(e.getActionCommand().equals("btnUpdate-PersonTableUI")) {
			checkPersonToUpdate();
		}
		
		else if(e.getActionCommand().equals("btnCancel-PersonFormUpdateUI")) {
			this.personFormUpdateUI.setVisible(false);
			this.personTableUI.setVisible(true);
		}
		
		else if(e.getActionCommand().equals("btnUpdate-PersonFormUpdate")) {
			updatePerson();
		}
		
		else if(e.getActionCommand().equals("btnDelete-PersonTableUI")) {
			deletePerson();
		}
		
		else if(e.getActionCommand().equals("btnAddPerson-InitialMenuUI")) {
			this.initialMenuUI.setVisible(false);
			this.personFormUI = new PersonFormUI(this);
		}
		
		else if(e.getActionCommand().equals("btnDeletePerson-InitialMenuUI")) {
			this.initialMenuUI.setVisible(false);
			showPersons();
		}
		
		else if(e.getActionCommand().equals("btnUpdatePerson-InitialMenuUI")) {
			this.initialMenuUI.setVisible(false);
			showPersons();
			
		} else if(e.getActionCommand().equals("btnCallNext-PersonTableUI")) {
			callNextPerson();
		}
		
		else if(e.getActionCommand().equals("btnDeleteNpersons-PersonTableUI")) {
			deleteNpersons();
		}
		
		else if(e.getActionCommand().equals("btnFindById-PersonTableUI")) {
			findById();
		}
	}

	private void findById() {
		String idString = JOptionPane.showInputDialog(null, "ID number ");
		int idGiven = 0;
		personDAO = new PersonDAO();
		try {
			idGiven = Integer.valueOf(idString);
			ArrayList<String> person = personDAO.findById(idString);
			if (!person.isEmpty()) JOptionPane.showMessageDialog(null, person);
			else JOptionPane.showMessageDialog(null, "ID not found in the queue.");
			
		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, " Please enter a valid ID. ID has to be a numeric integer.");
		}
		
		
		
	}

	private void deleteNpersons() {
		
		try {
			String x = JOptionPane.showInputDialog("How many persons do you want to remove from the back of the queue?");
			int howMany = Integer.valueOf(x);
			int tempHowMany = howMany;
			personDAO = new PersonDAO();
			
			ArrayList<Person> persons = personDAO.findAll();
			
			if(persons.size() >= howMany) {
				// getting the queue sorted according to its persons priority
				for (int i = 0; i < persons.size(); i++) { list.insertOrdered(persons.get(i)); }
				
				while (howMany > 0) {
					// getting the id of the person deleted while being removed from the queue
					int id = list.deleteTail().getNode().getId();
					// deleting the person from the database
					personDAO.delete(String.valueOf(id));

				}
				ArrayList<Person> personsUpdated = personDAO.findAll();
				JOptionPane.showMessageDialog(null, "The last " + tempHowMany + " person(s) in the queue have been removed.\n"
						+ "Now there is(are) " + personsUpdated.size() + " person(s) in the queue");
			} else {
				JOptionPane.showMessageDialog(null, "There are " + persons.size() + 
						" personns in the queue.\n " + howMany + " is greater than " + persons.size());
			}
			personTableUI.setVisible(false);
			personTableUI = new PersonTableUI(this);
		} catch (NumberFormatException numberFormatException) {
			System.out.println(numberFormatException.getMessage());
		}
	}

	private void callNextPerson() {
		personDAO = new PersonDAO();
		
		ArrayList<Person> DB = personDAO.findAll();
		
		for (int i = 0; i < DB.size(); i++) {
			list.insertOrdered(DB.get(i));
		}
		
		System.out.println(list.getHead().getFirstName() + " is the head.");
		
		String headID = String.valueOf(list.getHead().getId());
		System.out.println("Head id: " + headID);
		
		System.out.println(list.getHead().getFirstName() + " has been called.");
		JOptionPane.showMessageDialog(null, list.getHead().getFirstName() + " has been called.\"");
		
		if (list.getSize() > 1)
			list.deleteHead();
				personDAO.delete(headID);
		
		if (DB.isEmpty()) {
			personTableUI.setVisible(false);
			initialMenuUI.setVisible(true);
		} else {
			personTableUI.setVisible(false);
			personTableUI = new PersonTableUI(this);
		}
	}

	/**
	 * 
	 */
	private void updatePerson() {
		personDAO = new PersonDAO();
		
		// getting data from user input
		String firstName = this.personFormUpdateUI.getTfFirstName().getText();
		String lastName = this.personFormUpdateUI.getTfLastName().getText();
		String passportNumber = this.personFormUpdateUI.getLblPassportNumber().getText();
		String priorityLevel = this.personFormUpdateUI.getCbPriorityLevel().getSelectedItem().toString();
		
		// new person instance populated with data from user input
		person = new Person(firstName, lastName, passportNumber, priorityLevel);
		
		// check if person is valid
		if(personDAO.isPersonValid(person)) {
			// updating person
			personDAO.update(this.personFormUpdateUI.getIdToUpdate(), person);
			JOptionPane.showMessageDialog(null, this.personFormUpdateUI.getPreviousFirstName() + " has been updated successfully to " + firstName + "!", firstName, JOptionPane.INFORMATION_MESSAGE);
			this.personFormUpdateUI.setVisible(false);
			showPersons();
		} else {
			JOptionPane.showMessageDialog(null, " name cannot be empty!!", "Empty field error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	private void checkPersonToUpdate() {
		// check if there is a row selected on the table
		if(this.personTableUI.getTable().getSelectedRowCount() == 1) {
			String id = (String) this.personTableUI.getTable().getValueAt(this.personTableUI.getTable().getSelectedRow(), 0);
			this.personTableUI.setVisible(false);
			this.personFormUpdateUI = new PersonFormUpdateUI(this);
			this.personFormUpdateUI.setIdToUpdate(id);
			
			this.personFormUpdateUI.setPreviousFirstName((String) this.personTableUI.getTable().getValueAt(this.personTableUI.getTable().getSelectedRow(), 1));
			this.personFormUpdateUI.getTfFirstName().setText(this.personFormUpdateUI.getPreviousFirstName());
			
			this.personFormUpdateUI.setPreviousLastName((String) this.personTableUI.getTable().getValueAt(this.personTableUI.getTable().getSelectedRow(), 2));
			this.personFormUpdateUI.getTfLastName().setText(this.personFormUpdateUI.getPreviousLastName());
			
			this.personFormUpdateUI.setPreviousPassport((String) this.personTableUI.getTable().getValueAt(this.personTableUI.getTable().getSelectedRow(), 3));
			this.personFormUpdateUI.getTfPassportNumber().setText(this.personFormUpdateUI.getPreviousPassport());
			
		} else {
			JOptionPane.showMessageDialog(null, "Please select one person", "No person selected", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	private void addNewPerson() {
		personDAO = new PersonDAO();
		
		// getting data from user input
		String firstName = personFormUI.getTfFirstName().getText();
		String lastName = personFormUI.getTfLastName().getText();
		String passportNumber = personFormUI.getTfPassportNumber().getText();
		String priorityLevel = personFormUI.getCbPriorityLevel().getSelectedItem().toString();
		
		// creating a new person
		person = new Person(firstName, lastName, passportNumber, priorityLevel);
		
		// check if person is valid
		if(personDAO.isPersonValid(person)) {
			personDAO.add(person);
			JOptionPane.showMessageDialog(null, firstName + " has been added successfully!!", firstName, JOptionPane.INFORMATION_MESSAGE);
			this.personFormUI.setVisible(false);
			showPersons();
		} else {
			JOptionPane.showMessageDialog(null, "cannot be empty!!", "Empty field error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	private void deletePerson() {
		String id;
		if(this.personTableUI.getTable().getSelectedRowCount() == 1) {
			id = (String) this.personTableUI.getTable().getValueAt(this.personTableUI.getTable().getSelectedRow(), 0);
			personDAO = new PersonDAO();
			ArrayList<String> personDelete = personDAO.findById(id);
			int op = JOptionPane.showConfirmDialog(null, "Do you want to delete?\n " + personDelete.get(1));
			
			if(op == JOptionPane.YES_OPTION) {
				
				ArrayList<String> personDeleted = personDAO.findById(id);
				JOptionPane.showMessageDialog(null, " HAS BEEN DELETED SUCCESSFULLY", personDeleted.get(1).toString().toUpperCase(), JOptionPane.WARNING_MESSAGE);
				personDAO.delete(id);
				this.personTableUI.setVisible(false);
				this.personTableUI = new PersonTableUI(this);
			} 
			
		} else {
			JOptionPane.showMessageDialog(null, "Please select one person", "No person selected", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	private void showPersonForm() {
		personFormUI = new PersonFormUI(this);
	}

	/**
	 * 
	 */
	private void showPersons() {
		personTableUI = new PersonTableUI(this);
		if(personTableUI.getTable().getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "There is no persons to show", "Empty Queue", JOptionPane.WARNING_MESSAGE);
			personTableUI.getBtnCallNext().setEnabled(false);
			personTableUI.getBtnDelete().setEnabled(false);
			personTableUI.getBtnUpdate().setEnabled(false);
			personTableUI.getBtnDeleteNpersons().setEnabled(false);
		}
	}

	/**
	 * 
	 */
	private void closeInitialMenu() {
		initialMenuUI.setVisible(false);
	}

}
