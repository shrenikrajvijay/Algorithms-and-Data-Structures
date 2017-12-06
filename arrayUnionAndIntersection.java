
import java.util.Arrays;

/* @author vijayshrenikraj
 Given two sorted arrays, find their union and intersection
Input:
arr1[] = {1, 3, 4, 5, 7}
arr2[] = {2, 3, 5, 6} 
Output:
Union : {1, 2, 3, 4, 5, 6, 7} 
Intersection : {3, 5}
 */

public class arrayUnionAndIntersection {
    public static void main(String[] args) {
        int [] arr1 = {1, 3, 4, 5, 7};
        int [] arr2 = {2, 3, 5, 6};
        System.out.println("Using simple loops, O(M+N) :");
        usingSimpleLoops(arr1.clone(), arr2.clone());
    }

    private static void usingSimpleLoops(int[] arr1, int[] arr2) {
        int i=0, j=0;
        System.out.println("Union: ");
        while(i< arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
            } else if (arr1[i] > arr2[j]){
                System.out.print(arr2[j]+" ");
                j++;
            } else {
                System.out.print(arr2[j]+" ");
                i++;
                j++;
            }
        }
        while(i < arr1.length){
            System.out.print(arr1[i]+" ");
            i++;
        }
        while(j < arr2.length){
            System.out.print(arr2[j]+" ");
            j++;
        }
        System.out.println();
        
        System.out.println("Intersection:");
        int k=0, l=0;
        while(k< arr1.length && l<arr2.length){
            if(arr1[k] < arr2[l]){
                k++;
            } else if (arr1[k] > arr2[l]){
                l++;
            } else {
                System.out.print(arr2[l]+" ");
                k++;
                l++;
            }
        }
        System.out.println();
        
    }
}

/*
Using simple loops, O(M+N) :
Union: 
1 2 3 4 5 6 7 
Intersection:
3 5 
BUILD SUCCESSFUL (total time: 0 seconds)
*/