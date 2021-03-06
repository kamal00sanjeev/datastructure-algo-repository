package com.ds.stk;

public interface IStack<T> {

	public void push(T item);

	public boolean isEmpty();
	
	public int getSize();

	public T pop();

	public T peek();
	
	public void displayStackItems();

}
