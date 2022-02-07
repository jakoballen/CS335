/**
 * Class Graph - class for representing a directed graph
 *
 * @author Jakob Allen
 */

import java.util.Stack;

public class Graph {
    private int numVertices;        //number of vertices
    private Vertex[] vertices;      //array of vertices

    /**
     * Constructor for graph
     * @param numVertices number of vertices in the graph
     */
    Graph(int numVertices){
        this.numVertices = numVertices;
        vertices = new Vertex[numVertices];
        for(int i = 0; i < numVertices; i++){
            vertices[i] = new Vertex(i, numVertices);
        }
    }

    /**
     * Add an edge to the graph. Start has out degree to end.
     * @param start vertex
     * @param end   vertex
     */
    public void addEdge(int start, int end){
        vertices[start].addEdge("out", vertices[end]);
        vertices[end].addEdge("in", vertices[start]);
    }

    /**
     * Determine if two vertices are adjacent
     * @param v1 first vertex
     * @param v2 second vertex
     * @return boolean determining if the vertices are adjacent
     */
    public boolean areAdjacent(int v1, int v2){
        return vertices[v1].isAdjacentTo(vertices[v2]);
    }

    //getters and setters
    public int getNumVertices(){
        return numVertices;
    }

    /**
     * Convert graph to string
     * @return String representing the graph
     */
    public String toString(){
        String r = "";
        for(Vertex vertex : vertices){
            r += vertex.toString() + "\n";
        }
        return r;
    }

    /**
     * Use topological sort to traverse the graph
     * @return String showing the path taken
     */
    public String sort() {
        Stack<Integer> path = new Stack<>();            //keep track of path taken
        boolean visited[] = new boolean[numVertices];   //keep track of which vertices have been visited

        //check all the vertices
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                sort(i, path, visited);
            }
        }

        //Convert the stack into a string
        return printPath(path);
    }

    /**
     * Private helper method for topological sort
     * @param vertex current vertex
     * @param path used to keep track of the result
     * @param visited array to keep track of vertices that have been visited
     */
    private void sort(int vertex, Stack<Integer> path, boolean[] visited) {
        visited[vertex] = true;  //Mark node as visited

        //Check adjacent vertices
        Vertex[] vOut = vertices[vertex].getOut();   //vertices that the current vertex points to
        for(int i = 0; i<vOut.length; i++){
            if(vOut[i] != null) {
                int nextVertex = vOut[i].getLabel();

                if (!visited[nextVertex]) {  //move to next unvisited adjacent vertex
                    sort(nextVertex, path, visited);
                }
            }
        }

        //Add vertex to result path
        path.push(vertices[vertex].getLabel());

        //Print current path with new vertex added
        //System.out.println(printPath(path));
        System.out.println("Iteration "+path.size()+": vertex "+printPath(path));
    }

    private String printPath(Stack<Integer> p) {
        Stack<Integer> path = (Stack<Integer>) p.clone();

        String r = "[" + path.pop();
        while (!path.empty()) {
            r += ", " + path.pop();
        }
        return r + "]";
    }
}
