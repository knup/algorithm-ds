/**
 * Hashtable.java 
 * Implementation of a generic chained Hashtable
 *
 * @author anupkhadka
 */

package map;

import java.lang.String;

public class Hashtable<K,V> {

	/* This class implements a HashNode */
	private class HashNode<K,V> {
		K key;
		V value;
		HashNode next;

		private HashNode(K key, V value, HashNode<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private HashNode<K,V>[] hashNodeArray;

	public Hashtable(int size) {
		hashNodeArray = new HashNode[size];
	}

	/**
	 * @param the key
	 * @return get hash index for the key
	 */
	private int getIndex(K key) {
		return key.hashCode()%hashNodeArray.length;
	}

	/**
	 * Inserts a key/value pair to the Hash table
	 * @param the key
	 * @param the value
	 */
	public void insert(K key, V value) {
		int index = getIndex(key);
		HashNode<K,V> iterator = hashNodeArray[index];
		while(iterator != null) {
			if(iterator.key.equals(key)) {
				//update value
				iterator.value = value;
				return;
			}
			iterator = iterator.next;
		}
	
		HashNode<K,V> newNode = new HashNode(key, value, hashNodeArray[index]);
		hashNodeArray[index] = newNode;
	}		 

	/**
	 * @param the key
	 * @return the value
	 */
	public V get(K key) {
		int index = getIndex(key);
		HashNode node = hashNodeArray[index];
		while(node != null) {
			if(node.key.equals(key)) {
				return (V)node.value;
			}
			node = node.next;
		}
		return null;
	}

	/**
 	 * Unit Testing
	 * @param args
	 */
	public static void main(String [] args) {
		Hashtable<String, String> countryCapitals = new Hashtable(10);
		countryCapitals.insert("Nepal", "Kathmandu");
		countryCapitals.insert("USA", "Washington D.C");
		countryCapitals.insert("India", "New Delhi");
		countryCapitals.insert("Bhutan", "Thimpu");

		System.out.println("Capital city of Nepal is: "+countryCapitals.get("Nepal"));
		System.out.println("Capital city of USA is: "+countryCapitals.get("USA"));
		System.out.println("Capital city of India is: "+countryCapitals.get("India"));
		System.out.println("Capital city of Bhutan is: "+countryCapitals.get("Bhutan"));
	}
}
