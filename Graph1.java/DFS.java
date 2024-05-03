import java.util.*;
public class DFS {
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
    public static void main(String Args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        dfs(graph,0);
    }
}
