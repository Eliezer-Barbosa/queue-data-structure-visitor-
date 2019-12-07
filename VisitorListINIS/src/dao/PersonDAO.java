package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectionFactory;
import model.Person;
import model.enums.PriorityLevel;

public class PersonDAO {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public PersonDAO() {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void add(Person person) {

			String sql = "INSERT INTO queue(firstName, lastName, passport, priority) VALUES(?,?,?,?)";
			try { 
	            preparedStatement = connection.prepareStatement(sql);
	            
	            preparedStatement.setString(1, person.getFirstName());
	            preparedStatement.setString(2, person.getLastName());
	            preparedStatement.setString(3, person.getPassportNumber());
	            preparedStatement.setString(4, person.getPriorityLevel());

	            preparedStatement.execute();
	            preparedStatement.close();
	           
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        } 
		
	}
	
	public boolean isPersonValid(Person person) {
		
		if(person.getFirstName().isEmpty() || person.getLastName().isEmpty() || person.getPassportNumber().isEmpty()) {
			return false;
		}
		
		return true;
	}

	public ArrayList<Person> findAll() {
		
		String sql = "SELECT * FROM queue";
		ArrayList<Person> persons = new ArrayList<Person>();
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery(sql);
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String passportNumber = resultSet.getString("passport");
				String priorityLevel = resultSet.getString("priority");
				
				Person p = new Person(id, firstName, lastName, passportNumber, priorityLevel);
				
				persons.add(p);
			}
			return persons;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void update(String id, Person personUpdated) {
		String sql = "UPDATE queue SET firstName=?, lastName=?, passport=?, priority=? WHERE id = " + Integer.parseInt(id);
		
		try { 
			
			// preparedStatement receives the sql query
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, personUpdated.getFirstName());
            preparedStatement.setString(2, personUpdated.getLastName());
            preparedStatement.setString(3, personUpdated.getPassportNumber());
            preparedStatement.setString(4, personUpdated.getPriorityLevel());
            
            // execute query
            preparedStatement.execute();
            
            // close connection
            preparedStatement.close();
            
        } 
        catch (SQLException u) { 
        	//b = false;
            throw new RuntimeException(u);
        } 
		
	}
	
	public void delete(String id) {
		
		String sql = "DELETE FROM queue WHERE id = " + id;
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.execute();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> findById(String id) {
		
		String sql = "SELECT * FROM queue WHERE id = " + id;
		ArrayList<String> person = new ArrayList<>();
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery(sql);
			
			while(resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String passport = resultSet.getString("passport");
				String priority = resultSet.getString("priority");
				
				person.add(id);
				person.add(firstName);
				person.add(lastName);
				person.add(passport);
				person.add(priority);
				
			}
			return person;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
