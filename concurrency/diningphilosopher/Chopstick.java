/** 
 * This class implements a chopstick in dining philosopher problem
 *
 * @author anupkhadka
 */

package concurrency.diningphilosopher;

import java.util.concurrent.locks.*;

public class Chopstick {

	private Lock lock;

	public Chopstick() {
		/* initialize lock to a new ReentrantLock */
		lock = new ReentrantLock();
	}

	/**
	 * @return true if the chopstick can gain access to lock 
     */
	public boolean pickup() {
		return lock.tryLock();
	}

	/**
	 * Release the lock 
	 */
	public void putdown() {
		lock.unlock();
	}
}
