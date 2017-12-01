/* @author vijayshrenikraj
 Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in 
the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should 
return 15 (sum of 3, 5 and 7).Answer the question in most efficient way
Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110
 */

public class MaxSum {
    private static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int arr[] = {5,  5, 10, 40, 50, 35};
        System.out.println("Using recursion, O(N^2) :");
        usingRecursion(arr.clone());
        System.out.println("Using simple include/exclude, O(N) :");
        usingIncludeExclude(arr.clone());
    }

    private static void usingRecursion(int[] arr) {
        for(int i=0;i<arr.length;i++){
            getMaxSumStarting(arr, i, arr[i]);
        }
        System.out.println(maxSum);
    }

    private static void getMaxSumStarting(int[] arr, int i, int currSum) {
        if(currSum > maxSum) maxSum = currSum;
        for(int j=i+2;j<arr.length;j++){
            getMaxSumStarting(arr, j, currSum+arr[j]);
        }
    }

    private static void usingIncludeExclude(int[] arr) {
        int inc = arr[0];
        int exc = 0;
        for(int i=1;i<arr.length;i++){
            int prevInc = inc;
            if(arr[i]+exc > inc) inc = arr[i]+exc;
            if(prevInc > exc) exc = prevInc;
        }
        int result = (inc > exc)? inc: exc;
        System.out.println(result);
    }
    
}
    
/*

*/