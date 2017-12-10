/*
 * Object representing a node on the double linked list
 */
public class Node {
	private Object data;
	private Node previous;
	private Node next;
	
	public Node(Object data, Node previous, Node next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	

}
