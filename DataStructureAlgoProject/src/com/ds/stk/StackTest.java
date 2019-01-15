package com.ds.stk;

public class StackTest {

	public static void main(String[] args) {

		//IStack<Integer> stk1 = new StackImpl<>();
		IStack<Integer> stk = new StackUsingArray<>(5);
		stk.displayStackItems();
		System.out.println("------------------------------");
		stk.push(12);
		stk.push(13);
		stk.push(100);

		stk.displayStackItems();
		System.out.println("------------------------------");

		stk.pop();
		stk.push(102);
		stk.push(34);
		stk.pop();
		stk.push(123);
		stk.push(456);
		stk.displayStackItems();

		System.out.println("Stack size is: " + stk.getSize());
		System.out.println("Stack peek : " + stk.peek());
		System.out.println("-------------------------");
		stk.push(666);
		stk.push(345);
		
		stk.displayStackItems();
		System.out.println("Stack size is: " + stk.getSize());
		System.out.println("Stack peek : " + stk.peek());
	}

}
