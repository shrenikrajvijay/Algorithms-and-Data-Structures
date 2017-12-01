
import java.util.Arrays;
import java.util.HashMap;

/*
   @author vijayshrenikraj

   A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
   I/P : 3 3 4 2 4 4 2 4 4
   O/P : 4
 */

public class MajorityElement {
    public static void main(String[] args) {
        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Using Voting algorithm O(N):");
        usingVoting(a);
        System.out.println("Using Map O(N):");
        usingMap(a);
        System.out.println("Using HashMap O(N):");
        usingHashMap(a);
        System.out.println("Using Binary Search Tree O(N log N):");
        usingBinarySearchTree(a);
    }

    private static void usingVoting(int[] a) {
        int number=0 ;
        int count=0;
        for(int i=0;i<a.length;i++){
            if(count ==0){
                number = a[i];
                count=1;
            }
            else if(a[i] == number) count++;
            else count--;
        }
        
        int actualCount = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == number) actualCount++;
        }
        
        if(actualCount > (a.length/2)){
            System.out.println(number);
        }
    }

    private static void usingMap(int[] a) {
        int []count = new int[10000000];
        for(int i=0;i<a.length;i++){
            count[a[i]]++;
            if(count[a[i]] >= (a.length/2)){
                System.out.println(a[i]);
                return;
            }
        }
        System.out.println("No Major element");
    }

    private static void usingHashMap(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                int count = map.get(a[i]);
                if(count+1 > (a.length/2)){
                    System.out.println(a[i]);
                    return;
                } else {
                    map.put(a[i], count+1);
                }
            } else {
                map.put(a[i],1);
            }
        }
        System.out.println("No Majority Element");
    }

    private static void usingBinarySearchTree(int[] a) {
        Node root = new Node();
        root.value = a[0];
        root.count = 1;
        for(int i=1;i<a.length;i++){
            if(a[i] == root.value) root.count++;
            else if(a[i] > root.value){ root.right = insertIntoTree(root.right, a[i], a.length);}
            else {root.left = insertIntoTree(root.right, a[i], a.length);}
        }
    }

    private static Node insertIntoTree(Node root, int i, int arrLength) {
        if(root == null){
            root = new Node();
            root.value = i;
            root.count = 1;
            return root;
        }
        if(root.value == i){
            root.count++;
            if(root.count >= (arrLength/2)) {
                System.out.println(root.value);
                System.exit(0);
            }
        }
        else if(i < root.value) { root.left = insertIntoTree(root.left, i , arrLength); }
        else { root.right = insertIntoTree(root.right, i, arrLength); }
        return root;
    }
}

class Node{
    int value;
    int count;
    Node left;
    Node right;
}


/*
run:
Using Voting algorithm O(N):
4
Using Map O(N):
4
Using HashMap O(N):
4
Using Binary Search Tree O(N log N):
4
BUILD SUCCESSFUL (total time: 0 seconds)
*/