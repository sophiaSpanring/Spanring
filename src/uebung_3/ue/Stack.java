package uebung_3.ue;

import kapitel_3.vl.IFIterator;
//import kapitel_3.vl.SList;
import uebung_2.ue.MySList;

public class Stack {
	private MySList list = new MySList();
	private int size = 0;
	
	public void push(Object data) {
		list.prepend(data);
		size++;
	}
	
	public Object pop() {
		Object data = null;
		
		IFIterator it = list.iterator();
		
		if (it.hasNext()) {
			size--;
			data = it.next();
			list.remove(data);
		}
		return data;
	}
	
	public Object top() {
		Object data = null;
		
		IFIterator it = list.iterator();
		
		if (it.hasNext()) {
			data = it.next();
		}
		return data;
	}
	
	public boolean empty() {
		return size == 0;
	}
}
