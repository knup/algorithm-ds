/* 
 * This class merges two sorted arrays
 * @author anupkhadka
 */

package array;

import java.lang.String;
import java.lang.StringBuilder;

public class MergeSortedArrays
{
	private static String getArrayString(int [] array)
    {
        StringBuilder str = new StringBuilder();
        str.append("[");

        for(int i = 0; i < array.length; i++) {
            if(i != 0) {
                str.append(",");
            }
            str.append(array[i]);
        }
        str.append("]");

        return str.toString();
    }

	private static void merge(int [] merge, int [] first, int [] second)
	{
		int i = 0, j = 0, k = 0; 
		int firstLength = first.length;
		int secondLength = second.length;

		while(i < firstLength && j < secondLength) {
			if(first[i] < second[j]) {
				merge[k++] = first[i++];
			} else {
				merge[k++] = second[j++];
			}
		}
	
		//copy remaining elements
		while(i < firstLength) {
			merge[k++] = first[i++];
		}

		while(j < secondLength) {
			merge[k++] = second[j++];
		}
	}

	public static void main(String [] args)
	{
		int [] first = {1,2,7,14,19};
		int [] second = {0,2,11,19,21};
		int [] merged = new int[first.length + second.length];
		merge(merged,first,second);

		System.out.println("First array  : "+ getArrayString(first));	
		System.out.println("Second array : "+ getArrayString(second));	
		System.out.println("Merged array : "+ getArrayString(merged));	
	}
}
