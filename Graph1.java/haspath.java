import java.util.*;
public class haspath {
    static class  Edge {
        int src; //SOURCE
        int des; //DESTINATION
        int wt; //WEIGHT OF THE EDGE
        public Edge(int s , int d , int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>(); //initialized with empty AL
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[6].add(new Edge(6, 5, 1));
        
    }
    public static void main(String Args[]) {
        int V = 7;
    ArrayList<Edge> graph[] = new ArrayList[V];
    creategraph(graph);
    has_path(graph, 0, 5);
    }
    public static boolean has_path(ArrayList<Edge> graph[],int src, int des) {
       boolean[] vis = new boolean[graph.length];
       vis[src] = true;
       if(src==des) {
        return true;
       }
       for(int i=0;i<graph[src].size();i++) {
        Edge e = graph[src].get(i);
        //e.des = neighbour
        if(!vis[e.des] && has_path(graph, e.des, des)) {
            return true;
        }
       }
       return false;
    }
}
