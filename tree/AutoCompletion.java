/**
 * This class uses a trie to perform autocompletion when a prefix is given
 * 
 * @author anupkhadka
 */

package tree;

public class AutoCompletion {
	private Trie trie;

	public AutoCompletion() {
		trie = new Trie();
	}

	/**
	 * Adds a word to the AutoCompletion Trie 
     */
	public void add(String word) {
		trie.add(word);
	}

	/**
	 * Given a prefix, suggest words in the trie 
     */
	public void suggest(String prefix) {
		trie.suggest(prefix);
	}

	/**
	 * @param args
	 */
	public static void main(String [] args) {
		AutoCompletion app = new AutoCompletion();
		app.add("cat");
		app.add("caterpillar");
		app.add("caterer");
		app.add("catty");
		app.add("catmandu");

		System.out.println();
		System.out.println("Words in dictionary: cat, caterpillar, caterer, catty, catmandu");
		System.out.println();
		System.out.println("Suggestions for prefix cab:");
		app.suggest("cab");
		System.out.println();
		System.out.println("Suggestions for prefix ca:");
		app.suggest("ca");
		System.out.println();
		System.out.println("Suggestions for prefix cate:");
		app.suggest("cate");
		System.out.println();
		System.out.println("Suggestions for prefix catt:");
		app.suggest("catt");
		System.out.println();
	}	
}
