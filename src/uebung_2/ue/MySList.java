package uebung_2.ue;

import kapitel_3.vl.IKey;
import kapitel_3.vl.SList;

public class MySList extends SList {
	protected Node searchForLastNode() {
		Node current = head;
		
		while(current != null && current.next != null) {
			current = current.next;
		}
		
		return current;
	}
	
	public void append(Object data) {
		Node lastNode = searchForLastNode();
		Node newNode = new Node(data, null);
		
		if (lastNode == null) {
			head = newNode;
		} else {
			lastNode.next = newNode;
		}
	}
	
	protected Node searchForNode(IKey key) {
		Node current = head;
		
		while(current != null && !key.matches(current.data)) {
			current = current.next;
		}
		
		return current;
	}
	
	public boolean insert(IKey key, Object data) {
		Node previousNode = searchForNode(key);
		
		if (previousNode != null) {
			previousNode.next = new Node(data, previousNode.next);
		}
		
		return previousNode != null;
	}
	
	public MySList searchAll(IKey key) {
		MySList allList = new MySList();
		
		Node current = head;
		while(current != null) {
			if (key.matches(current.data)) {
				allList.prepend(current.data);
			}
		}
		
		return allList;
	}
	
	public Object getFirst() {
		return (head != null) ? head.data : null;
	}
}
