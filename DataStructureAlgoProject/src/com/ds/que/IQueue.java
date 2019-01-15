package com.ds.que;

public interface IQueue<T> {

	public boolean enqueue(T item);

	public T dequeue();

	public T getFront();

	public T getRear();

	public int queueSize();
	
	public void displayQueueItems();

}
