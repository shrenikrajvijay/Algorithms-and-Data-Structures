/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vijayshrenikraj
 */
public class Graph {
    MyList [] arr;
    Graph(int noOfNodes){
        arr = new MyList[noOfNodes];
        for(int i=0;i<noOfNodes;i++){
            arr[i] =  new MyList();
            arr[i].value = i;
            arr[i].next = null;
        }
    }

    void addEdge(int from, int to) {
        MyList vertex = arr[from];
        while(vertex.next != null){
            vertex = vertex.next;
        }
        MyList node = new MyList();
        node.value = to;
        vertex.next = node;
    }

    void dfs(int startVertex) {
        int currVertex = startVertex;
        int [] visited = new int[arr.length];
        do{
            doDfs(arr, visited, startVertex);
            startVertex = (startVertex+1) % arr.length;
        } while(startVertex != currVertex);
    }

    private void doDfs(MyList[] arr, int[] visited, int i) {
        if(visited[i] == 1) return;
        System.out.println(i+" ");
        visited[i] = 1;
        MyList start = arr[i];
        while(start.next != null){
            doDfs(arr, visited, start.next.value);
            start = start.next;
        }
    }
}

class MyList {
    int value;
    MyList next;
}


