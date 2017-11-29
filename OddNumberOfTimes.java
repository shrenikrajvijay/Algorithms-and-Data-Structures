/*
Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.

I/P = [1, 2, 3, 2, 3, 1, 3]
O/P = 3
 */

/**
 *
 * @author vijayshrenikraj
 */
public class OddNumberOfTimes {
    public static void main(String[] args) {
        int a[] = {1,2,3,2,3,1,3};
        System.out.println("Using Two Loops O(N^2):");
        usingTwoLoops(a);
        System.out.println("Using Map O(N):");
        usingMap(a);
        System.out.println("Using EX-OR O(N):");
        usingExor(a);
    }

    private static void usingTwoLoops(int[] a) {
        for(int i=0;i<a.length;i++){
            int count = 1;
            for(int j=0;j<a.length;j++){
                if(i==j)continue;
                if(a[i] == a[j])count++;
            }
            if(count%2 == 1){
                System.out.println(a[i]);return;
            }
        }
    }

    private static void usingMap(int[] a) {
        int [] map = new int[10000000];
        for(int i=0;i<a.length;i++){
            map[a[i]]++;
        }
        for(int i=0;i<map.length;i++){
            if(map[i]%2 == 1){
                System.out.println(i);
                return;
            }
        }
    }

    private static void usingExor(int[] a) {
        int exor = a[0];
        for(int i=1;i<a.length;i++){
            exor = exor ^ a[i];
        }
        System.out.println(exor);
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