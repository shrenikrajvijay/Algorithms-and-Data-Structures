
import java.util.Arrays;

/* @author vijayshrenikraj
 Given an array arr[] of integers, find out the difference between any two elements such that 
larger element appears after the smaller number in arr[].
i/p [2, 3, 10, 6, 4, 8, 1]
o/p 8
 */

public class MaxDiffBetTwoElem {
    private static int maxDiff = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println("Using Two loops, O(N^2) :");
        usingTwoLoops(arr.clone());
        System.out.println("Using temporary array, O(N) :");
        usingTemporaryArray(arr.clone());
        System.out.println("Using simple loop, O(N) :");
        usingSimpleLoop(arr.clone());
    }

    private static void usingTwoLoops(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] > arr[i]){
                    int currDiff = arr[j] - arr[i];
                    if(currDiff > maxDiff){
                        maxDiff = currDiff;
                    }
                }
            }
        }
        System.out.println(maxDiff);
    }

    private static void usingTemporaryArray(int[] arr) {
        int [] temp = new int[arr.length];
        int currMax = arr[arr.length-1];
        temp[arr.length-1] = 0;
        for(int i=(arr.length)-2;i>=0;i--){
            if(arr[i] > currMax){
                temp[i] = currMax;
                currMax = arr[i];
            } else {
                temp[i] = currMax;
            }
        }
        for(int i=0;i<temp.length;i++){
            int maxDiff = Integer.MIN_VALUE;
            if(temp[i] - arr[i] > maxDiff){
                maxDiff = temp[i] - arr[i];
            }
        }
        System.out.println(maxDiff);
    }

    private static void usingSimpleLoop(int[] arr) {
        int minValue = arr[0];
        int maxDiff = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] > minValue){
                if(arr[i] - minValue > maxDiff){
                    maxDiff = arr[i] - minValue;
                }
            } else {
                minValue = arr[i];
            }
        }
        System.out.println(maxDiff);
    }
}

/*

*/