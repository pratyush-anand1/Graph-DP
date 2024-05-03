import java.util.*;
// shortest path in undirected graph with unit edge weights and src node is 0
//T.C= O(V+E) 

public class shortestpath {
    public static void main(String Args[]) {

    }
    
    // class pair {
    //     int f;
    //     int s;
    //     public pair(int f , int s) {
    //         this.f=f;
    //         this.s=s;
    //     }
    // }
    
    public int[] shortest_path(ArrayList<ArrayList<Integer>> adj , int V,int src) {
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it : adj.get(node)) {
                if(dist[it]>dist[node]+1) {
                    dist[it] = dist[node]+1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<V;i++) {
            if(dist[i]==Integer.MAX_VALUE) {
                dist[i]=-1;
            }
        }
        return dist;
    }
}
