/** 
 * This class implements SelectionSort on an array of integers. 
 * Selection sort is a simple sorting algorithm, which has an O(n^2) 
 * time complexity
 *
 * @author anupkhadka
 */

package sort;

public class SelectionSort {

	public static void sort(int [] arr) {
		int currentMinimum, currentMinimumIndex, tmp;
		for(int i = 0; i < arr.length; i++) {
			currentMinimumIndex = i;
			currentMinimum = arr[i];

			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < currentMinimum) {
					currentMinimumIndex = j;
					currentMinimum = arr[j];
				}
			}

			if(i != currentMinimumIndex) {
				//swap element in ith position with element in currentMinimumIndex position
				tmp = arr[i];
				arr[i] = arr[currentMinimumIndex];
				arr[currentMinimumIndex] = tmp;
			}
		}
	}
	
	public static void main(String [] args) {
  		int [] arr = {9,3,1,5,23,1000,3,2,766,2,7,7,99};
        System.out.println("Array before selection sort    : "+ Print.getArrayString(arr));
        sort(arr);
        System.out.println("Array after selection sort     : "+ Print.getArrayString(arr));
	}
} 
