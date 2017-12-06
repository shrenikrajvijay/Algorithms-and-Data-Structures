
import java.util.Arrays;

/*
There are two sorted arrays. First one is of size m+n containing only m elements. 
Another one is of size n and contains n elements. 
Merge these two arrays into the first array of size m+n such that the output is sorted

I/P = int mPlusN[] = {2, 8, NA, NA, NA, 13, NA, 15, 20};
        int N[] = {5, 7, 9, 25};

O/P =   2 5 7 8 9 13 15 20 25
 */

/**
 *
 * @author vijayshrenikraj
 */
public class MergeTwoArray {
    public static void main(String[] args) {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        System.out.println("Using Special Merge O(N):");
        usingSpecialMerge(mPlusN, N);
        
    }

    private static void usingSpecialMerge(int[] a, int [] N) {
        int i = 0; int j =0;
        while(j< a.length && i < a.length){
            while(i < a.length && a[i] == -1)i++;
            while(j < a.length && a[j] != -1)j++;
            if(i < a.length && j < a.length) {
                swap(a, i, j);
            }
        }
        int k1 = 0; int k2 = 0;
        while(a[k1] == -1){
            k1++;
        }
        int index = 0;
        while(k1<a.length && k2<N.length && index < a.length){
            //System.out.println(k1+" "+k2);
            //System.out.println(Arrays.toString(a));
            if(a[k1] < N[k2]){
                int temp = a[index];
                a[index] = a[k1];
                a[k1] = temp;
                k1++;
            } else {
                int temp = a[index];
                a[index] = N[k2];
                N[k2] = temp;
                k2++;
            }
            index++;    
        }
        System.out.println(Arrays.toString(a));
        while(k1 != a.length && index < a.length){
            swap(a, index, k1);
            index++;
            k1++;
        }
        while(k2 != N.length && index < a.length){
            swap(a, index, k2);
            index++;
            k2++;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


  
}

/*
run:
Using Two Loops O(N^2):
3
Using Map O(N):
3
Using EX-OR O(N):
3
BUILD SUCCESSFUL (total time: 0 seconds)
*/