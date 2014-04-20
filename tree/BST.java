/**
 * BST.java 
 * Implementation of a generic binary search tree
 *
 * @author anupkhadka
 */

package tree;

import java.lang.Comparable;

public class BST<E extends Comparable<E>> {

	/* 
	 * Class that represents a BST Node
     */	
	private class BSTNode<E extends Comparable<E>> {
		private E element;
		private BSTNode<E> left;
		private BSTNode<E> right;

		private BSTNode(E element) {
			this.element = element;
			this.left = null;	
			this.right = null;
		}
	}

	private BSTNode<E> root;

	public BST() {
		root = null;
	}

	/*
     * Helper function for public insert method
	 */
	private BSTNode<E> insert(BSTNode<E> node, E element) {
		if(node == null) {
			node = new BSTNode(element);
		} else if(element.compareTo(node.element) < 0) {
			node.left = insert(node.left, element);
		} else {
			node.right = insert(node.right, element);
		}
		return node;
	}

	/**
     * Inserts an element to BST
	 * @param the element to insert
	 */
	public void insert(E element) {
		root = insert(root, element);
	}

	/*
   	 * Helper function for printPreOrder
	 */
	private void preOrder(BSTNode<E> node) {
		if(node != null) {
			System.out.println(node.element);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
     * Perform pre order traversal of BST and print
     */
	public void printPreOrder() {
		System.out.println("--- PreOrder Traversal ---");
		preOrder(root);
	}

	/*
	 * Helper function for printInOrder
	 */
	private void inOrder(BSTNode<E> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.element);
			inOrder(node.right);
		}
	}

	/**
     * Perform in order traversal of BST and print
     */
	public void printInOrder() {
		System.out.println("--- InOrder Traversal ---");
		inOrder(root);
	}

	/*
     * Helper method for printPostOrder
	 */
	private void postOrder(BSTNode<E> node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.element);
		}
	}

	/**
     * Perform post order traversal of BST and print
     */
	public void printPostOrder() {
		System.out.println("--- PostOrder Traversal ---");
		postOrder(root);
	}		

	/**	
     * Unit Testing 
	 * @param args
 	 */
	public static void main(String [] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.insert(new Integer(3));
		bst.insert(new Integer(1));
		bst.insert(new Integer(2));
		bst.insert(new Integer(4));
		
		bst.printPreOrder();
		bst.printInOrder();
		bst.printPostOrder();
	}
}
