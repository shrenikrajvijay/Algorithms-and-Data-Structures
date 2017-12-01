
import java.util.Arrays;

/* @author vijayshrenikraj
 Write a program to print all the LEADERS in the array. 
An element is leader if it is greater than all the elements to its right side. 
And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

 */

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        System.out.println("Using two loops, O(N^2) :");
        usingTwoLoops(arr.clone());
        System.out.println("Using temporary array, O(N) :");
        usingTemporaryArray(arr.clone());
    }

    private static void usingTwoLoops(int[] arr) {
        outer:
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] < arr[j]) continue outer;
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void usingTemporaryArray(int[] arr) {
        int [] temp = new int[arr.length];
        int currMax = arr[arr.length-1];
        for(int i=arr.length-1; i >= 0; i--){
            if(arr[i] >= currMax){
                currMax = arr[i];
            }
            temp[i] = currMax;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= temp[i]){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}

/*
run:
Using two loops, O(N^2) :
17 5 2 
Using temporary array, O(N) :
17 5 2 
BUILD SUCCESSFUL (total time: 0 seconds)

*/