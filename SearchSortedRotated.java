/*
 An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 
 */

import java.util.Arrays;
/**
 *
 * @author vijayshrenikraj
 */
public class SearchSortedRotated {
    public static void main(String[] args) {
        // TODO code application logic here\
        
        int A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = 2;
        System.out.println("Direct Search, O(N) :");
        usindirectSearch(A, n);
        System.out.println("Using Special Binary Search, O(Log N)");
        usingSpecialBinarySearch(A, n);
    }

    private static void usindirectSearch(int[] A, int n) { 
        for(int i=0;i<A.length;i++){
            if(A[i] == n){
                System.out.println(i);
                return;
            }
        }
    }  

    private static void usingSpecialBinarySearch(int[] A, int n) {
        specialBinarySearch(A, 0, A.length-1, n);
    }

    private static void specialBinarySearch(int[] A, int start, int end, int n) {
        int mid = (start+end)/2;
        if(A[mid] == A[n]){
            System.out.println(mid);return;
        }
        if((A[start] < A[mid]) && (n >= A[start] && n < A[mid])){
            regularBinarySearch(A, start, mid-1, n);
        } else if((A[start] < A[mid]) && (n < A[start] && n > A[mid])){
            specialBinarySearch(A, mid+1, end, n);
        } else if((A[start] > A[mid]) && (n >= A[start] && n < A[mid])){
            specialBinarySearch(A, start, mid-1, n);
        } else {
            regularBinarySearch(A, mid+1, end, n);
        }
        
    }

    private static void regularBinarySearch(int[] A, int start, int end, int n) {
        int mid = (start+end)/2;
        if(A[mid] == n) {
            System.out.println(mid);return;
        } else if(n < A[mid]) regularBinarySearch(A, start, mid-1, n);
        else regularBinarySearch(A, mid+1, end, n);
    }
    
}


/*
run:
Direct Search, O(N) :
7
Using Special Binary Search, O(Log N)
7
BUILD SUCCESSFUL (total time: 0 seconds)
*/