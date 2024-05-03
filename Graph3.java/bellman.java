import java.util.*;
// works for directed graphs only
// helps in finding shortest path even with negative edge weights and negative cycle detection
// single source shortest path algo - bellman ford , edges can be any order

//relax all the edges n-1 times sequentially  edges are given in format (u,v,wt)
// n is number of nodes in total
//relaxation -> (dist[u]+wt<dist[v])--> dist[v]=dist[u]+wt

//since in a graph of n nodes  in worst case you will take n-1 edges to reach from 1st to last thereby we iterate for n-1 iterations 

// if after nth iteration the distance array of (n-1)th iteration and nth oteration changes (or) relaxes then there exists a negative weight cycle in the graph 

public class bellman {
    public static void main(String Args[]) {
        
    }
    public int[] bellman_ford(int V , ArrayList<ArrayList<Integer>> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<V;i++) {
            for(ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u]+ wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // for nth relaxation to check negative cycle
        for(ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[v]) {
                int[] temp = new int[1];
                temp[0]=-1;
                return temp; 
            }
        }
        return dist;
    }
}
