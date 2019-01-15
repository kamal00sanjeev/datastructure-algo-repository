package com.ds.que;

import com.ds.ll.Node;
/**
 * Queue implementation using LinkedList Node
 * @author a1eqaautomation
 *
 * @param <T>
 */
public class QueueImpl<T> implements IQueue<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueImpl() {
		this.front = this.rear = null;
		this.size = 0;
	}

	@Override
	public boolean enqueue(T item) {
		Node<T> newNode = new Node<>(item);
		if (front == null && rear == null) {
			this.front = this.rear = newNode;
		}
		rear.setNext(newNode);
		this.rear = newNode;
		size++;
		return true;
	}

	@Override
	public T dequeue() {
		if (front == null && rear == null) {
			System.out.println("Queue is empty. Can't remove queue item");
			return null;
		}
		Node<T> frontItem = front;
		front = front.getNext();
		size--;
		return frontItem.getData();
	}

	@Override
	public T getFront() {
		return this.front.getData();
	}

	@Override
	public T getRear() {
		return this.rear.getData();
	}

	@Override
	public int queueSize() {
		return size;
	}

	@Override
	public void displayQueueItems() {
		if(front == null) {
			System.out.println("Queue is empty.");
			return;
		}
		Node<T> tmpNode = front;
		while(tmpNode != null) {
			System.out.print(tmpNode.getData() +":<-");
			tmpNode = tmpNode.getNext();
		}
		System.out.println();
	}

}
