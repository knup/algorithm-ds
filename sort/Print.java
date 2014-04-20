/**
 * Helper print functions
 * @author anupkhadka
 */

package sort;

public class Print {
    public static String getArrayString(int [] array) {
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
}
