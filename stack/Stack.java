/**
 * Stack.java
 * Implementation of a generic stack
 *
 * @author anupkhadka
 */

package stack;

import java.lang.Comparable;
import java.util.EmptyStackException;

public class Stack<E extends Comparable<E>> {

	/* Class that implements StackNode */	
	private class StackNode<E extends Comparable<E>> {
		private E element;
		private StackNode<E> next;

		private StackNode(E element) {
			this.element = element;
			this.next = null;
		}
	}

	private StackNode<E> top;

	public Stack() {
		top = null;
	}

	/**
	 * @param the element to push
	 */
	public void push(E e) {
		StackNode<E> node = new StackNode(e);
		node.next = top;
		top = node;
	}
	
	/**
	 * @return the element that is popped
	 */
	public E pop() {
		StackNode<E> ret;

		if(empty()) {
			throw new EmptyStackException();
		}
		
		ret = top;
		top = top.next;

		return ret.element;
	}

	/**
	 * @return true if stack is empty, false otherwise
	 */
	public boolean empty() {
		return top == null;
	}
	
	/** 
	 * @return String representation of Stack
	 */
	@Override
	public String toString() 
	{
		StringBuilder str = new StringBuilder();
		StackNode<E> cursor = top;
		while(cursor != null) {
			if(cursor != top) {
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
		Stack<Integer> stack = new Stack();
	
		for(i = 0; i < arr.length; i++) {
			stack.push(new Integer(arr[i]));
		}
		
		System.out.println("Stack: "+stack);

		try {
			while(true) {
				element = stack.pop();
				System.out.println("Popped: "+element);
				System.out.println("New stack: "+stack);
			}
		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
	}
}
