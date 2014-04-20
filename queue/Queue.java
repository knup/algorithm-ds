/**
 * Queue.java 
 * Implementation of a generic queue
 *
 * @author anupkhadka
 */

package queue;

import java.lang.Comparable;
import java.util.NoSuchElementException;

public class Queue<E extends Comparable<E>> {

	/* This class represents a queue node */	
	private class QueueNode<E extends Comparable<E>> {
		private E element;
		private QueueNode<E> next;

		public QueueNode(E element) {
			this.element = element;
			this.next = null;
		}
	}

	private QueueNode<E> head;

	public Queue() {
		head = null;
	}

	/** 
	 * Appends specified element to the end of the queue 
	 * @param the element to add to queue
	 */
	public void enqueue(E e) {
		QueueNode<E> node = new QueueNode(e);
		if(head == null) {
			head = node;
		} else {
			QueueNode<E> cursor = head;
			while(cursor.next != null) {
				cursor = cursor.next;
			}
			node.next = null;
			cursor.next = node;	
		}
	}

	/**
	 * @return the head of the queue
	 */
	public E dequeue() {
		QueueNode<E> ret;

		if(empty()) {
			throw new NoSuchElementException();
		}
		
		ret = head;
		head = head.next;

		return ret.element;
	}

	/**
	 * @return true if queue is empty, false otherwise
	 */
	public boolean empty() {
		return head == null;
	}

	/**
	 * @return string representation of the stack 
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		QueueNode<E> cursor = head;
		while(cursor != null) {
			if(cursor != head) {
				str.append("-->");
			}
			str.append(cursor.element.toString());
			cursor = cursor.next;
		}
		return str.toString();		
	}

	/**
	 * @param args
	 */
	public static void main(String [] args) {
		int [] arr = {1,3,7,8};
		int i;
		Integer element;
		Queue<Integer> queue = new Queue();
	
		for(i = 0; i < arr.length; i++) {
			queue.enqueue(new Integer(arr[i]));
		}
		
		System.out.println("Queue: "+queue);

		try {
			while(true) {
				element = queue.dequeue();
				System.out.println("Dequeued: "+element);
				System.out.println("New queue: "+queue);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
}
