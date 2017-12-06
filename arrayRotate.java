
import java.util.Arrays;

/* @author vijayshrenikraj
 Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
i/p {1, 2, 3, 4, 5, 6, 7}, i=2
o/p 3 4 5 6 7 1 2 
 */

public class arrayRotate {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        int d=2;
        System.out.println("Moving temporary array, O(N) :");
        usingTemporaryArray(arr.clone(), d);
    }

    private static void usingTemporaryArray(int[] arr, int d) {
        int [] temp = new int[d];
        int i;
        for(i=0;i<d;i++){
            temp[i] = arr[i];
        }
        for(i=i;i<arr.length;i++){
            arr[i-d] = arr[i];
        }
        for(int j=0;j<d;j++){
            arr[i-d] = temp[j];
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }
}

/*

*/