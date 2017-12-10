import java.util.ArrayList;
/*
 * Author Jonathan Farrell
 * This is a class representing a double linked list
 */

public class DoubleLinkedList {
	private Node head;
	private int size;
	
	public DoubleLinkedList() {//constructor
		head = null;
		size = 0;
	}
	public Node getNode(int pos) {//returns node at position 'pos'
		Node n = null;
		for (int i = 1; i <= pos; i++) {
			if(i==1) {
				n=this.head;
			}else {
				n=n.getNext();
			}
		}
		return n;
	}
	public Node getHead() {//returns the head node
		return head;
	}
	
	public void add(Object data) {//adds a node
		if(head == null) {
			head = new Node(data, null, null);
		}else {
			//find last node
			Node tail = getNode(this.size);
			//create the new node
			Node new_node = new Node(data, null, null);
			//set the next pointer
			tail.setNext(new_node);
			//set the previous pointer
			tail.setPrevious(getNode(this.size-1));
		}
		size+=1;
	}
	
	public void remove(int pos) { //removes node at position 'pos'
		if(pos==1) {//remove first node
			Node n = getNode(1);
			this.head = n.getNext();
			if(head!=null) {
				this.head.setPrevious(null);
			}
		}else if(pos==size && size > 1) {//remove last node
			Node n = getNode(pos-1);
			n.setNext(null);
		}else {//remove from middle
			Node previous = getNode(pos-1);
			Node next = getNode(pos+1);
			previous.setNext(next);
			next.setPrevious(previous);
		}
	}
	public void removeById(String id) {//removes the node containing a patient with id 'id'
		Node n;
		Patient p;
		for(int i = 1; i <=size; i++) {
			n = getNode(i);
			p= (Patient) n.getData();
			if(p.getId().equals(id)) {
				this.remove(i);
				size-=1;
			}
		}
	}
	public Patient getById(String id) {//returns the patient data with the id 'id'
		Node n;
		Patient p = null;
		for (int i = 1; i <=size; i++) {
			n = getNode(i);
			p = (Patient) n.getData();
			if(p.getId() == id) {
				break;
			}
		}
		return p;
	}
	public void updateById(String id, Patient patient) {//updates the node containing a patient with id 'id'
		Node n;
		Patient p;
		for(int i =1; i<=size; i++) {
			n = getNode(i);
			p = (Patient) n.getData();
			if(p.getId() == id) {
				n.setData(patient);
			}
		}
	}
	
	public String toString() {
		String output = "";
		
		if(head != null) {
			Node n = head.getNext();
			output = " - " + head.getData().toString() + "\n";
			while(n!=null) {
					output += " - " + n.getData().toString() + "\n";
					n = n.getNext();
			}
		}
		return output;
	}

	public Patient getHighestPriority() {//creates an array of all of the patients with the highest priority, and returns the fist
		ArrayList<Patient> highestPriorities = new ArrayList<Patient>();
		Node highestNode = null;
		Node n = null;
		Patient p;
		int highestPriority = 0;
		for(int i = 1; i<=size; i++) {
			n = getNode(i);
			p = (Patient) n.getData();
			if (p.getPriority() == highestPriority) {
				highestPriorities.add(p);
			}else if(p.getPriority() > highestPriority) {
				highestPriorities.clear();
				highestPriorities.add(p);
				highestPriority = p.getPriority();
			}
		}
		Patient firstHighest = highestPriorities.get(0);
		return firstHighest;
	}
	
	public Patient getFirstNonPriority() {//returns the first patient on the list that does not have a priority value set yet
		Node n;
		Patient p = null;
		Patient result = null;
		for(int i = 1; i<=size; i++) {
			n = getNode(i);
			p = (Patient) n.getData();
			if(p.getPriority() == 0) {
				result = p;
				break;
			}
		}
		return result;
	}
		
}
