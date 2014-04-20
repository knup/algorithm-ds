/** 
 * This class implements classic dining philosophers problems using Java Threads
 * Some philosophers are sitting in a round table with one chopstick between 
 * each of them. A philosopher needs both chopsticks to eat, and he always
 * picks up the left chopstick before right. This implementation makes sure
 * all philosophers get to eat their food. 
 * 
 * @author anupkhadka
 */

package concurrency.diningphilosopher;

public class DiningPhilosophers {

	private Philosopher [] philosophers;
	private final int numPhilosophers;

	public DiningPhilosophers(int num) {
		numPhilosophers = num;
		philosophers = new Philosopher[numPhilosophers];
		for(int i = 0; i < numPhilosophers; i++) {
			philosophers[i] = new Philosopher(i+1);
		}
	}

	public void start() {
		for(int i = 0 ; i < numPhilosophers; i++) {
			philosophers[i].start();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String [] args) {
		int numPhilosophers = 5; 
		DiningPhilosophers app = new DiningPhilosophers(numPhilosophers);

		app.start();	
	}
}
