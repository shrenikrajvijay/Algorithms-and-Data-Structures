/* @author vijayshrenikraj
 
 */

public class MyLibrary {
    public static void swap(int [] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    public static int findGCD(int big, int small){
        if(small == 0)return big;
        else return findGCD(small, big%small);
    }
}

/*

*/