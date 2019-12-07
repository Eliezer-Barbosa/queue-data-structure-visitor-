package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a doubly linked list.
 *
 * @author Eliezer
 */

public class DoublyLinkedList {
    /**
     * Head of the queue, which is the first person in the queue
     */
    private Node head;
    /**
     * Tail of the queue, which is the last person in the queue
     */
    private Node tail;
    /**
     * Size of the queue, which is how many person are in the queue
     */
    private int size;

    /**
     * Default Constructor, having its both head and tail pointing to null, that means the queue is empty
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Insert a person at the head of the queue
     *
     * @param person Person to be added in the queue
     * 
     */
    public void insertHead(Person person) {
    	// creates a new Node object, passing the person given as its argument
        Node newNode = new Node(person);
        // if the queue is empty, add the person to the end of the queue
        if (isEmpty())
            tail = newNode;
        // otherwise, set this node to be the previous node of the head of this queue
        // then, set the next of the new node to be the head of this queue
        // finally, set the head of the queue to be the new node.
        else
            head.previous = newNode;
        newNode.next = head;
        head = newNode;
    }

    /**
     * Insert a person at the tail
     *
     * @param person Person to be inserted
     */
    public void insertTail(Person person) {
    	// creates a new Node object, passing the person given as its argument
        Node newNode = new Node(person);
        // set the next of the new node to null, because the last person in the queue does not have next, only previous
        newNode.next = null;
        // if the queue is empty, the new node will be both tail and head of the queue
        if (isEmpty()) {
            tail = newNode;
            head = tail;
        // otherwise, the last person in the queue will have this new node as its next
        // then, the new node will have its previous to be the last person in the queue
        // finally, we set the last person to be the new node
        } else {
            tail.next = newNode; 
            newNode.previous = tail; 
            tail = newNode; 
        }
    }

    /**
     * Delete the first person in the queue, which is the head
     *
     * @return The new head
     */
    public Node deleteHead() {
    	// creates a temporary variable to hold the head of the queue
        Node temp = head;
        // then, we set the head with the value of its next node, which is the second person in the queue
        head = head.next;
        // at this point, the head is actually the second person in the queue
        // so, we set its previous (which is the head that we want to delete) to null.
        head.previous = null;
        // check if head is null, 
        // if so, set its tail to null as well
        // it means that the head removed was the only one in the queue
        if (head == null)
            tail = null;
        // decrement size of the queue by 1 and return the actual head, which is the variable temp
        this.size--;
        return temp;
    }

    /**
     * Delete the last person in the queue
     *      *
     * @return The new tail
     */
    public Node deleteTail() {
    	// save the last person in a temporary variable
        Node temp = tail;
        // assign the value of the penultimate(last but one) in the queue to be the tail of the queue
        tail = tail.previous;
        // by setting null in here, we are telling that it is now the last one in the queue, because we are pointing its next value to null
        tail.next = null;
        // check if tail is null, which means the queue is empty
        // if so, set its head to null as well
        if (tail == null) {
            head = null;
        }
        // decrement size of the queue by 1 and return the actual tail, which is the variable temp
        this.size--;
        return temp;
    }

    /**
     * Delete the person from somewhere in the list
     *
     * @param person to be deleted
     */
    public void delete(Person person) {
    	// assigning the head of the queue to a variable called current
        Node current = head;
        // while the person, starting from the head, is different from the person given to be deleted
        while (current.person != person) {
        	// check if current is not the last person in the queue
            if (current != tail) {
            	// then go to the next person, until we find the person that matches the person given
                current = current.next;
              // if we get to the tail and no person matches the person given to be deleted
              // means that the person wasn't find in the queue
              // throw an error exception
            } else {// If we reach the tail and the element is still not found
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }
        // if the person is the first in the queue, just call deleteHead() method
        if (current == head)
            deleteHead();
        // if the person is the last one in the queue, just call deleteTail() method
        else if (current == tail)
            deleteTail();
        // if the person is neither the head nor the tail of the queue, means that we need to delete it
        // making its previous and next pointers to point to nowhere, the java garbage collector takes care of it
        // making this element (person) disappear from our queue
        else {
        	// here we are getting rid of the person that we want to delete from the queue
        	// for example, let's say that we have in the queue 5 persons
        	// a <---> b <---> c <---> d <---> e
        	// in line 1, we are getting the next node of the previous person to be deleted to point
        	// to the next node of the person to be deleted
        	// in line 2, we are getting the previous node of the next node of the person to be deleted to point
        	// to the previous node of the person to be deleted
            current.previous.next = current.next; // line 1
            current.next.previous = current.previous; // line 2
        }
    }

    /**
     * Inserts person and reorders the queue according to its priority level
     *
     * @param person Person to be added to  the queue
     */
    public void insertOrdered(Person person) {
    	// creates a new node, passing the person given as its argument
        Node newNode = new Node(person);
        // get the head of the queue and save it in a variable called current
        Node current = head;
        // while the head is different not null and the level of the person given is greater or equal to the current person level
        while (current != null && person.getLevel() <= current.person.getLevel())
        	// person given priority is greater or equal the current person, get to the next person
            current = current.next;
        // level of person given is equal the level of the head of the queue
        if (current == head)
            insertHead(person);
        // the queue is empty, just add the person to the end of the queue
        else if (current == null)
            insertTail(person);
        
        // otherwise, the person given is neither equals to the head nor the tail of the queue
        // at this point we know that the priority of the current person is greater or equals to the priority of the person given
        // here, the variable called newNode is the node that holds the person given
        // in line 1, we are getting the previous value of the current person and assigning it to be the previous node of person given
        // in line 1, both current person and the person given are pointing to the same previous node
        // in line 2, we are making the previous node of the current person to point its next pointer to the new person added in the queue
        // in line 3, we are making the current person to be the next of the person given
        // in line 4, we are making the new person added to be the previous node of the current person
        else {
            newNode.previous = current.previous; // line 1
            current.previous.next = newNode; // line 2
            newNode.next = current; // line 3
            current.previous = newNode; // line 4
        }
        // increases the size of the queue by 1
        this.size++;
    }
    
    /**
     * Prints all persons in the queue
     */
    public void display() { 
        Node current = head;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
    
    public ArrayList<Person> getNodes() {
    	Node current = head;
    	ArrayList<Person> p = new ArrayList<>();
    	while (current != null) {
    		p.add(current.getNode());
    		current = current.next;
    	}
    	return p;
    }
    
    public ArrayList<Person> getPersons() {
    	Node current = head;
    	ArrayList<Person> p = new ArrayList<>();
    	while (current != null) {
    		p.add(current.person);
    		current = current.next;
    	}
    	return p;
    }

    /*
     *
     * @return true if list is empty
     * check if the head is null, that means the queue is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

	public Person getHead() {
		return this.head.person;
		
	}

	public Person getTail() {
		return this.tail.person;
	}

	public int getSize() {
		return this.size;
	}
}
