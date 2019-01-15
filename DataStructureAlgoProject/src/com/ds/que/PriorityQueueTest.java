package com.ds.que;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(23);
		pq.add(54);
		pq.add(532);
		pq.add(67);
		pq.add(23);

		pq.forEach(s -> System.out.print(s + ","));
		
		System.out.println("\ndequeue: "+pq.remove());
		System.out.println("\ndequeue: "+pq.remove());
		System.out.println("\ndequeue: "+pq.remove());
		System.out.println("\ndequeue: "+pq.remove());
		System.out.println("\ndequeue: "+pq.remove());

	}

}
