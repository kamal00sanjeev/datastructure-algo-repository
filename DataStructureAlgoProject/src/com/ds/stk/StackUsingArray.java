package com.ds.stk;

public class StackUsingArray<T> implements IStack<T> {

	private T[] arr = null;
	private int top = -1;
	private int size = 0;
	private int capacity;

	@SuppressWarnings("unchecked")
	public StackUsingArray(int cap) {
		this.capacity = cap;
		this.arr = (T[]) new Object[cap];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void push(T item) {
		if (top == capacity - 1) {
			System.out.println("Stack is already full. Resizing array.");
			T[] newArr = (T[]) new Object[capacity * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			this.arr = newArr;
		}
		arr[++top] = item;
		this.size++;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public T pop() {
		if (top == -1) {
			System.out.println("Can't pop items. Stack is already empty");
			return null;
		}
		T popItem = arr[top];
		arr[top--] = null;
		this.size--;
		return popItem;
	}

	@Override
	public T peek() {
		if (top == -1) {
			System.out.println("Can't pop items. Stack is already empty");
			return null;
		}
		return arr[top];
	}

	@Override
	public void displayStackItems() {
		if (top == -1) {
			System.out.println("No items in stack.");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.println("[" + arr[i] + "]");
		}
	}

}
