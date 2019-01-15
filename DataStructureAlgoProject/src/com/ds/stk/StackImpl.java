package com.ds.stk;

import com.ds.ll.Node;

public class StackImpl<T> implements IStack<T>{
	
	private Node<T> top;
	private int stackSize;
	
	public StackImpl() {
		this.top = null;
		this.stackSize = 0;
	}
	
	@Override
	public int getSize() {
		return stackSize;
	}

	@Override
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.setNext(top);
		top = newNode;
		stackSize++;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public T pop() {
		Node<T> topNode = top;
		top = top.getNext();
		stackSize--;
		return topNode.getData();
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return top.getData();
	}

	@Override
	public void displayStackItems() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		Node<T> tmpNode = top;
		while(tmpNode != null) {
			System.out.println(tmpNode.getData() );
			tmpNode = tmpNode.getNext();
		}
	}

}
