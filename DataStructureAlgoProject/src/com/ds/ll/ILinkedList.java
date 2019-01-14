/**
 * 
 */
package com.ds.ll;

/**
 * @author Sanjeev
 *
 */
public interface ILinkedList<T> {

	public boolean isEmpty();

	public void insertAtFirst(T item);

	public void insertAtLast(T item);

	public void insertAtPosition(int pos, T item);

	public boolean removeAtFirst();

	public boolean removeAtLast();

	public boolean removeAtPosition(int pos);

	public void displayListItems();

}