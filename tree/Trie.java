/** 
 * Trie.java
 * Implementation of a trie (prefix tree)
 * 
 * @author anupkhadka
 */

package tree;

public class Trie {
	
	/* Class implements a TrieNode */
	private class TrieNode {
		TrieNode []children;
		private boolean isWord;
		private String word;

		private TrieNode() {
			children = new TrieNode[26];
			isWord = false;
			word = null;
		}

		private TrieNode getChild(char c) {
			int index = c - 'a';
			if(index >= 0 && index <= 26) {
				return children[index];
			}
			return null;
		}

		private TrieNode[] getChildren() {
			return children;
		}

		private boolean isWord() {
			return this.isWord;
		}

		private String getWord() {
			return this.word;
		}

		private void setChild(char c) {
			int index = c - 'a';
			if(index >= 0 && index <= 26) {
				children[index] = new TrieNode();
			}
		}

		public void setIsWord(boolean isWord) {
			this.isWord = isWord;
		}

		public void setWord(String word) {
			this.word = word;
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Adds a word to the Trie 
 	 * @param the word to add to Trie
	 */
	public void add(String word) {
		TrieNode cursor = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cursor.getChild(c) == null) {
				cursor.setChild(c);
			}
			cursor = cursor.getChild(c);
		}
		cursor.setIsWord(true);
		cursor.setWord(word);
	}

	/**
	 * Given a prefix, suggest and print  words in the trie 
	 * @param prefix
	 */
	public void suggest(String prefix) {
		TrieNode cursor = root;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if((cursor = cursor.getChild(c)) == null) {
				System.out.println("No suggestions found!");	
			}
		}

		//reached end of prefix, now get the children of the last character
		//of prefix
		traverse(cursor);
	}

	/**
	 * Traverse through the node, and print all the 
	 * available words
	 */
	public void traverse(TrieNode node) {
		if(node != null) {
			if(node.isWord()) {
				System.out.println(node.getWord());
			}
			for(TrieNode child: node.getChildren()) {
				traverse(child);
			}
		}
	}
}
