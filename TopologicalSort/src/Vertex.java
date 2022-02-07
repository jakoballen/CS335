/**
 * Class Vertex - represents a vertex in a graph
 *
 * @author Jakob Allen
 */

public class Vertex {
    private int label;                   //number of the vertex
    private int numIn = 0, numOut = 0;   //number for in and out degrees
    private Vertex[] in;                 //vertices that point to this vertex
    private Vertex[] out;                //vertices that this vertex points to


    /**
     * Constructor for the vertex
     * @param label number of the vertex
     * @param numVertices total number of vertices
     */
    public Vertex(int label, int numVertices){
        this.label = label;
        this.in = new Vertex[numVertices/2];
        this.out = new Vertex[numVertices/2];
    }

    /**
     * Add the pointers for the edge.
     * @param inout determine if it is in or out degree
     * @param other other vertex on the edge
     */
    public void addEdge(String inout, Vertex other){
        if(inout.equals("out")){
            out[numOut] = other;
            numOut++;
        }else{
            in[numIn] = other;
            numIn++;
        }
    }

    //getters and setters
    public int getNumIn(){
        return numIn;
    }

    public int getNumOut(){
        return numOut;
    }

    public int getNumAdjacent(){
        return numIn + numOut;
    }

    public Vertex[] getIn(){
        //trim array to size necessary
        Vertex[] newIn = new Vertex[numIn];
        for(int i = 0; i < numIn; i++){
            newIn[i] = in[i];
        }
        return newIn;
    }

    public Vertex[] getOut(){
        //trim array to size necessary
        Vertex[] newOut = new Vertex[numOut];
        for(int i = 0; i < numOut; i++){
            newOut[i] = out[i];
        }

        return newOut;
    }

    public Vertex[] getAdjacent(){
        Vertex[] adj = new Vertex[numOut+numIn];
        int oi=0;
        for(int i = 0; i < adj.length; i++){
            if(i < numIn){
                adj[i] = in[i];
            }else{
                adj[i] = out[oi];
                oi++;
            }
        }
        return adj;
    }

    public int getLabel(){
        return label;
    }

    /**
     * Determines if this vertex is adjacent to the given vertex
     * @param o other vertex
     * @return boolean representing if vertex is adjacent to the other one
     */
    public boolean isAdjacentTo(Vertex o){
        for(int i = 0; i<numIn; i++){       //check in degrees
            if(in[i].equals(o)){
                return true;
            }
        }
        for(int i = 0; i<numOut; i++){      //check out degrees
            if(out[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    /**
     * Convert vertex to string
     * @return String representing the vertex
     */
    public String toString(){
        String r = "Vertex "+label + " Out: [";
        for(int i = 0; i < numOut; i++){
            if(i == 0){
                r += out[i].getLabel();
            }else{
                r +=", " + out[i].getLabel();
            }
        }
        r+= "] In: [";
        for(int i = 0; i < numIn; i++){
            if(i == 0){
                r += in[i].getLabel();
            }else{
                r +=", " + in[i].getLabel();
            }
        }
        r += "]";
        return r;
    }
}