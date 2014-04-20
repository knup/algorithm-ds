/**
 * Philosopher.java
 * Implementation of a Philosopher class in dining philosopher
 * problem
 * 
 * @author anupkhadka
 */

package concurrency.diningphilosopher;

public class Philosopher extends Thread {

	private int id;	
	private int numBites = 100;
	private Chopstick left;
	private Chopstick right;

	public Philosopher(int id) {
		this.id = id;
		this.left = new Chopstick();
		this.right = new Chopstick();
	}

	public void eat() {
		if(pickup()) {
			System.out.println("Philosopher "+id+" is eating");
			putdown();
		}
	}

	/**
 	 * @return true if philosopher can pickup a chopstick
	 */
	public boolean pickup() {
		if(!left.pickup()) {
			return false;
		}	

		if(!right.pickup()) {
			//if philosopher has already picked left, but can't pick right
			//then drop the left to avoid deadlock
			left.putdown();
			return false;
		}
		return true;
	}

	public void putdown() {
		left.putdown();
		right.putdown();
	}

	public void run() {
		for(int i = 0; i < numBites; i++) {
			/* eat until the philosopher eats the numBites he needs */
			eat();
		}
		System.out.println("Philosopher "+id+" is done eating");
	}
}
