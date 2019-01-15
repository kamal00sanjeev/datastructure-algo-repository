package com.ds.ll;

public class LListTest {

	public static void main(String[] args) {
		ILinkedList<Integer> llist = new LinkedListImpl<>();
		llist.insertAtFirst(11);
		llist.insertAtFirst(9);
		llist.insertAtFirst(5);
		llist.insertAtLast(22);
		llist.insertAtLast(33);
		llist.displayListItems();
		
		llist.removeAtFirst();
		llist.removeAtLast();
		llist.displayListItems();
		
		llist.removeAtPosition(2);
		llist.displayListItems();

		llist.insertAtPosition(1, 44);
		llist.displayListItems();
	}

}
