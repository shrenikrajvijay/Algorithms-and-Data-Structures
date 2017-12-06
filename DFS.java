/* @author vijayshrenikraj
 Depth First Search of a Graph.
 */

public class DFS {
    public static void main(String[] args) {
        System.out.println("Using recursion, O(N) :");
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(g);
    }
}

/*

*/