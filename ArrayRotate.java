
import java.util.Arrays;

/* @author vijayshrenikraj
 Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
Input:  arr[] = [1, 2, 3, 4, 5, 6, 7]
            d = 2
Output: arr[] = [3, 4, 5, 6, 7, 1, 2] 
 */

public class ArrayRotate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d=2;
        System.out.println("Using Temporary Array, O(N) :");
        usingTemporaryArray(arr.clone(), d);
        System.out.println("Using reversal algorithm, O(N) :");
        usingReversalAlgorithm(arr.clone(), d);
        System.out.println("Using Juggling algorithm, O(N) :");
        usingJugglingAlgorithm(arr.clone(), d);
    }

    private static void usingTemporaryArray(int[] arr, int d) {
        int [] temp = new int[d];
        int i; int j=0;
        for(i=0;i<d;i++){
            temp[i] = arr[i];
        }
        while(i<arr.length){
            arr[i-d] = arr[i];
            i++;j++;
        }
        for(i=0;i<temp.length;i++){
            arr[i+j] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void usingReversalAlgorithm(int[] arr, int d) {
        ReverseArrayOfString.recurseReverse(arr, 0, d-1);
        ReverseArrayOfString.recurseReverse(arr, d, arr.length-1);
        ReverseArrayOfString.recurseReverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void usingJugglingAlgorithm(int[] arr, int d) {
        int gcd = MyLibrary.findGCD(arr.length, d);
        System.out.println(gcd);
        for(int i=0;i<gcd;i++){
            int j = i;
            do{
                arr[j] = arr[j+d];
                j+=d;
                j = j%(arr.length);
            } while(i != j);
        }
        System.out.println(Arrays.toString(arr));
    }
}

/*

*/