import java.util.*;
public class create {
    static class Edge {
        int src; //SOURCE
        int des; //DESTINATION
        int wt; //WEIGHT OF THE EDGE
        public Edge(int s , int d , int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }
    //EDGE tuple {source,destination,weight}
    public static void main(String Args[]) {
       /*        (5)
        *    0--------1
                 (1) / \
                    /   \  (3)
                   2 ----3
            (2)   /   (1)
                 /
                4    
        */
        int V = 5;  //number of vertex
        ArrayList<Edge>[] graph = new ArrayList[V];
        //array of an arrayList where each  element of array has one or more EDGE tuples
        //initially it is null we need to initialize it to an empty arraylist
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>(); //initialized with empty AL
        }
        //0-vertex
        graph[0].add(new Edge(0, 1, 5));
        //1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1, 3, 3));
        //2-vertex
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        //3-vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3,1,3));
        //4-vertex
        graph[4].add(new Edge(4,2,2));
        //the above is implemented with the help of Adjacency List
        //it doesn't store more info and is optimized than matrix

        //2-Neighbours
        for(int i=0;i<graph[2].size();i++) {
            Edge e = graph[2].get(i); //src,dest,wt
            System.out.println(e.des);
        }
    }
}
