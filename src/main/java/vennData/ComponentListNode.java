package vennData;

public class ComponentListNode{
	
	private Component c;
	private ComponentListNode next, previous;
	
	public ComponentListNode(Component c, ComponentListNode next, ComponentListNode previous) {
		this.c = c;
		this.next = next;
		this.previous = previous;
	}
	
	public ComponentListNode getNext() {
		return this.next;
	}
	public ComponentListNode getPrevious() {
		return this.previous;
	}
	
	public Component getComponent() {
		return this.c;
	}
	
	public void setNext(ComponentListNode node) {
		this.next = node;
	}
	public void setPrevious(ComponentListNode node){
		this.previous = node;
	}
	
	public boolean hasNext() {
		if(this.next == null) {
			return false;
		}else {
			return true;
		}
	}
	public boolean hasPrevious() {
		if(this.previous == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public String toString() {
		return c.toString();
	}
}
