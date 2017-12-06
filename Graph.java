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
        for(int i=0;i<noOfNodes;i++){
            arr[i] =  new MyList();
        }
    }

    void addEdge(int from, int to) {
        MyList vertex = arr[from];
        while(vertex.value != 0){
            vertex = vertex.next;
        }
        vertex.value = to;
    }
}

class MyList {
    int value;
    MyList next;
}


