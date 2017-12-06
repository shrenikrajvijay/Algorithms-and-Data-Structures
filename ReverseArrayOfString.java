
import java.util.Arrays;

/* @author vijayshrenikraj

 We are given an array (or string), the task is to reverse the array.
Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

 */

public class ReverseArrayOfString {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Using two pointers, O(N) :");
        usingTwoPointers(arr.clone());
        System.out.println("Using Recursion, O(N) :");
        usingRecursion(arr.clone());
    }

    public static void usingTwoPointers(int[] arr) {
        int left = 0; int right = arr.length-1;
        while(left < right){
            MyLibrary.swap(arr, left++, right--);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void usingRecursion(int[] arr) {
        if(arr.length <= 1) return;
        recurseReverse(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void recurseReverse(int[] arr, int left, int right) {
        if(left < right && left < arr.length && right > -1){
            MyLibrary.swap(arr, left, right);
            recurseReverse(arr, ++left, --right);
        }
    }
}

/*
run:
Using two pointers, O(N) :
[6, 5, 4, 3, 2, 1]
Using Recursion, O(N) :
[6, 5, 4, 3, 2, 1]
BUILD SUCCESSFUL (total time: 0 seconds)
*/