/** 
 * This class finds square root of a number in O(logn) using binary search 
 * 
 * @author anupkhadka
 */

package search;

public class SquareRootTest  {

	private int sqrtBinarySearch(int lowIndex, int highIndex, int num) {
		int mid;

		if(lowIndex > highIndex) {
			return highIndex;
		}

		mid = (lowIndex+highIndex)/2;

		if((mid * mid) == num) {
			return mid; 
		} else if((mid * mid) > num) {
			highIndex = mid - 1;
		} else {
			lowIndex = mid + 1;
		}	
		return sqrtBinarySearch(lowIndex, highIndex, num);
	}


	public int sqrt(int num) {
		return sqrtBinarySearch(0, num, num);
	}	

	public static void main(String [] args) {
		SquareRootTest srt = new SquareRootTest();
		int num = 16; 
		int sqrt = srt.sqrt(num);
		
		System.out.println("Square root of "+num+" is "+sqrt); 
		
		num = 17; 
		sqrt = srt.sqrt(num);
		System.out.println("Square root of "+num+" is "+sqrt); 
	}
}
