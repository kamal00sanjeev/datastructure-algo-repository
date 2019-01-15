package com.ds.que;

public class QueueTest {

	public static void main(String[] args) {

		IQueue<Integer> q = new QueueUsingArray<>(10);
		q.displayQueueItems();
		q.enqueue(12);
		q.enqueue(34);
		q.enqueue(56);
		
		q.displayQueueItems();
		
		q.dequeue();
		q.enqueue(67);
		q.enqueue(78);
		q.enqueue(100);
		q.displayQueueItems();
		
		System.out.println("Front element: "+q.getFront());
		System.out.println("Tail element: "+q.getRear());
	}

}
