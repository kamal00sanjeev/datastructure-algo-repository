package com.ds.ll;

public class LinkedListImpl<T> implements ILinkedList<T> {

	private Node<T> head;
	private int listSize;

	public LinkedListImpl() {
		this.head = null;
		this.listSize = 0;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void insertAtFirst(T item) {
		// create new node using new item
		Node<T> newNode = new Node<>(item);
		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.setNext(head);
			this.head = newNode;
		}
		listSize++;
	}

	@Override
	public void insertAtLast(T item) {
		// create new node using new item
		Node<T> newNode = new Node<>(item);
		if (this.head == null) {
			this.head = newNode;
		} else {
			Node<T> tmpNode = this.head;
			while (tmpNode.getNext() != null) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.setNext(newNode);
		}
		listSize++;
	}

	@Override
	public void insertAtPosition(int pos, T item) {
		if (pos > listSize+1 || pos < 1) {
			System.out.println("Could not remove node. Invalid position in linkedlist");
			return;
		}
		if (pos == 1) {
			this.insertAtFirst(item);
			return;
		}
		if (pos == listSize + 1) {
			this.insertAtLast(item);
			return;
		}
		Node<T> newNode = new Node<>(item);
		Node<T> tmpNode = head;
		for (int i = 1; i < pos - 1; i++) {
			tmpNode = tmpNode.getNext();
		}
		newNode.setNext(tmpNode.getNext());
		tmpNode.setNext(newNode);
		listSize++;
	}

	@Override
	public boolean removeAtFirst() {
		if (head == null) {
			return false;
		}
		Node<T> tmpNode = head;
		this.head = tmpNode.getNext();
		tmpNode = null;
		listSize--;
		return true;
	}

	@Override
	public boolean removeAtLast() {
		if (head == null) {
			return false;
		}
		Node<T> tmpNode = head;
		while (tmpNode.getNext().getNext() != null) {
			tmpNode = tmpNode.getNext();
		}
		tmpNode.setNext(null);
		listSize--;
		return true;
	}

	@Override
	public boolean removeAtPosition(int pos) {
		if (pos > listSize || pos < 1) {
			System.out.println("Could not remove node. Invalid position in linkedlist");
			return false;
		}
		if (pos == 1) {
			return this.removeAtFirst();
		}

		if (pos == listSize) {
			return this.removeAtLast();
		}

		Node<T> tmpNode = head;
		for (int i = 1; i < pos - 1; i++) {
			tmpNode = tmpNode.getNext();
		}
		Node<T> nodeTodelete = tmpNode.getNext();
		tmpNode.setNext(nodeTodelete.getNext());
		nodeTodelete = null;
		listSize--;
		return true;
	}

	@Override
	public void displayListItems() {
		Node<T> tmpNode = this.head;
		while (tmpNode != null) {
			System.out.print(tmpNode.getData() + " -> ");
			tmpNode = tmpNode.getNext();
		}
		System.out.print(" null \n");
	}

}
