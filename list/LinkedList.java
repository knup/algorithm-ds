/**
 * LinkedList.java
 * Implementation of a generic doubly-linked list
 * 
 * @author anupkhadka
 */

package list;

import java.lang.Comparable;

public class LinkedList<E extends Comparable<E>> {
	
	/* Implements each node of a List */
	private class ListNode<E extends Comparable<E>> {
		private E element;
		private ListNode<E> prev;
		private ListNode<E> next;
	
		private ListNode(E element) {
			this.element = element;
			this.prev = null;
			this.next = null;
		}
	}

	private ListNode<E> head;
	
	public LinkedList() {
		head = null;
	}

	/**
	 * Appends the specified element to the end of the list
     * @param the element to be added
	 */
	void add(E e) {
		ListNode<E> node = new ListNode(e);
		if(head == null) {
			head = node;
		} else {
			ListNode<E> cursor = head;
			while(cursor.next != null) {
				cursor = cursor.next;
			}
			node.prev = cursor;
			node.next = null;
			cursor.next = node;
		}
	}

	/**
  	 * Inserts specified element to the beginning of the list 
  	 * @param the element to be added
	 */
	void addFirst(E e) {
		ListNode<E> node = new ListNode(e);
		node.next = head;
		node.prev = null;
		head = node;
	}

	/**
 	 * @param the element to search
	 * @return true if element found, false otherwise
  	 */
	boolean contains(E e) {
		ListNode<E> cursor = head;
		while(cursor != null) {
			if(e.compareTo(cursor.element) == 0) {
				return true;
			}
			cursor = cursor.next;
		}
		return false;
	}

	/**
  	 * Removes first occurence of the element
 	 * @param the element to be deleted 
	 * @return true if element found and deleted, false otherwise
	 */
	boolean remove(E e) {
		ListNode<E> cursor = head;
		while(cursor != null) {
			if(e.compareTo(cursor.element) == 0) {
				if(cursor == head) {
					head = head.next;
				} else {
					cursor.prev.next = cursor.next;
					cursor.next.prev = cursor.prev;
				}
				return true;
			}
			cursor = cursor.next;
		}
		return false;
	}

	/**
     * @return the string representation of the LinkedList
     */
	@Override	
	public String toString() {
		StringBuilder str = new StringBuilder();
		ListNode<E> cursor = head;
		str.append("[");
		while(cursor != null) {
			if(cursor != head) {
				str.append("-->");
			}
				
			str.append(cursor.element);	
			cursor = cursor.next;
		}
		str.append("]");
		return str.toString();
	}

	/* @param args
     * Unit Testing
 	 */
	public static void main(String [] args) {
		int [] arr = {1,3,7,8,10,23,21,44};
		LinkedList<Integer> list = new LinkedList();

		/* Test add */
		for(int i = 0; i < arr.length; i++) {
			list.add(new Integer(arr[i]));
		}
		System.out.println("List : "+list);

		/* Test remove */
		for(int i = 0; i < arr.length; i++) {
			list.remove(new Integer(arr[i]));
		}
		System.out.println("List : "+list);

		/* Test addFirst */
		for(int i = 0; i < arr.length; i++) {
			list.addFirst(new Integer(arr[i]));
		}
		System.out.println("List : "+list);
	
		/* Test contains */
		assert (list.contains(new Integer(23)) == true);
		assert (list.contains(new Integer(3)) == true);
		assert (list.contains(new Integer(9)) == false);
	} 
}
