package com.ds.que;

public class QueueUsingArray<T> implements IQueue<T> {

	private int front; // front position
	private int rear; // rear position
	private int capacity;
	private int qsize = 0;
	private T[] qArr;

	@SuppressWarnings("unchecked")
	public QueueUsingArray(int cap) {
		this.capacity = cap;
		this.qArr = (T[]) new Object[cap];
		this.front = this.rear = -1;
	}

	@Override
	public boolean enqueue(T item) {
		if (rear == -1) {
			front = 0;
			rear = 0;
			qArr[rear] = item;
		} else if (rear + 1 >= capacity) {
			System.out.println("Queue is full. Can't add more items");
			return false;
		} else if (rear + 1 < capacity) {
			qArr[++rear] = item;
		}
		qsize++;
		return true;
	}

	@Override
	public T dequeue() {
		if (front == -1) {
			System.out.println("No items in queue.");
			return null;
		}
		T dqItem = qArr[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			qArr[front++] = null;
		}
		qsize--;
		return dqItem;
	}

	@Override
	public T getFront() {
		return this.qArr[front];
	}

	@Override
	public T getRear() {
		return this.qArr[rear];
	}

	@Override
	public int queueSize() {
		return this.qsize;
	}

	@Override
	public void displayQueueItems() {
		if(rear == -1) {
			System.out.println("Queue is empty");
			return;
		}
		for(T item: qArr) {
			System.out.print(item+":<-");
		}
		System.out.println();
	}

}
