/** 
 * This class is a greedy solution to make change problem: 
 * Make change for n cents, using the smallest number of coins. 
 * The coins can be found in following denomination: 
 * 1 - cent
 * 5 - nickel
 * 10 - dime
 * 25 - quarter
 *
 * 32 cents therefore will give - 1 quarter, 1 nickel, 2 pennies
 *
 * Greedy solution doesn't always work though, for example, instead of 
 * above denominations, the denominations were: 
 * 25 cents
 * 24 cents
 * 8 cents
 * 1 cent
 *
 * Greedy algorithm will choose, 1 25 cent, and 8 1 cents making a total of 9 coins. 
 * The optimal solution however is 1 24 cent, and 1 8 cent with a total of 2 coins. 
 *
 * A dynamic solution as shown in MakeChangeGreedyAlgorithmDynamicProgramming.java is required
 *
 * @author anupkhadka
 */

package recursion;

import java.util.HashMap;

public class MakeChangeGreedyAlgorithm {
	private static final int[] COINS = {25, 10, 5, 1}; 
	private HashMap<Integer, Integer> change; 

	public MakeChangeGreedyAlgorithm() {
		change = new HashMap();
		for(int i = 0; i < COINS.length; i++) {
			change.put(new Integer(COINS[i]), new Integer(0));
		}
	}

	public void makeChangeRecurse(int n, int index) {
		if(n == 0 || index >= COINS.length) {
			return;
		}
		
		if(n >= COINS[index]) {
			change.put(COINS[index], new Integer(change.get(COINS[index]).intValue()+ 1));
			makeChangeRecurse(n - COINS[index], index); 
		} else {
			makeChangeRecurse(n, index+1); 
		}
	} 

	public void makeChange(int n) {
		makeChangeRecurse(n,0);
	}
	

	public void printChange() {
		for(int i = 0; i < COINS.length; i++) {
			System.out.println(COINS[i]+" cent coin: "+change.get(COINS[i])); 
		}
	}

	public static void main(String [] args) {

		MakeChangeGreedyAlgorithm driver = new MakeChangeGreedyAlgorithm();
	
		int n; 
		n = 32;	
		driver.makeChange(n);
		
		System.out.println("Making change for "+n+" cents using greedy algorithm...");
		
		driver.printChange();
	}
}
