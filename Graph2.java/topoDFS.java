import java.util.*;
public class topoDFS {
    public static void main(String Args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);

    }
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
            graph[i] = new ArrayList<>(); //initialized with empty arraylist
        }
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4,1,1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }
    public static void dfs(ArrayList<Edge> graph[],int curr) {
        //curr will be visited since it's being passed as argument
     boolean[] vis = new boolean[graph.length];
       System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.des]) {
                dfs(graph,e.des);
            }
        }
    }

    
}
