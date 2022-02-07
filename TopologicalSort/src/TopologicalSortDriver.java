/**
 * Class TopologicalSortDriver - initializes a graph and prints the topological traversal
 *
 * @author Jakob Allen
 */

public class TopologicalSortDriver {
    public static void main(String[] args) {
        Graph g = new Graph(8);     //initialize the graph

        //add edges to the graph
        g.addEdge(0,1);
        g.addEdge(0,6);

        g.addEdge(1,7);

        g.addEdge(2,6);
        g.addEdge(2,4);

        g.addEdge(3,0);

        g.addEdge(4,7);

        g.addEdge(5,6);

        System.out.println("Final Result: "+g.sort());   //print traversal of the graph
    }

}
