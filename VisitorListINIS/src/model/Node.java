package model;

public class Node {
	
	/**
     * Person of this node
     */
    public Person person;
    /**
     * This points to the node in front (next) of the new node
     */
    public Node next;
    /**
     * This points to the node behind (previous) the new node
     */
    public Node previous;

    /**
     * Constructor
     *
     * @param person Person of this node
     */
    public Node(Person person) {
        this.person = person;
    }

    /**
     * Displays the person of this node
     */
    public void displayNode() {
        System.out.print(person + " ");
    }
    
    public Person getNode() {
    	return person;
    }

}
