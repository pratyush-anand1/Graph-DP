import java.util.*;
public class BFS {
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
    public static void bfs(ArrayList<Edge> graph[]) { //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0); //source = 0
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) { //visit curr
            System.out.print(curr+" ");
               vis[curr] = true;
               for(int i=0;i<graph[curr].size();i++) {
                Edge e = graph[curr].get(i);
                q.add(e.des);
               }
            }
        }
    
    }

    public ArrayList<Integer> bfs_2(int V , ArrayList<ArrayList<Integer>> adj) { //striver bfs
        ArrayList<Integer> Bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            Bfs.add(node);
            for(Integer i : adj.get(node)) {
                if(vis[i]==false) {
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return Bfs;
    }
    public static void main(String Args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        bfs(graph);
    }
}
