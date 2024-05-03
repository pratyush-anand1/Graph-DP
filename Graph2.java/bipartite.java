import java.util.*;

public class bipartite {
    
    public static void main(String Args[]) {
        int V = 7;
       int[] color = new int[V];
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       Arrays.fill(color, -1);
       for(int i=0;i<V;i++) {
        if(color[i]==-1) {
            if(isBipartite(i, V, adj, color)==false) {
                System.out.println(false);
            }
        }
       }
    }
    public static boolean isBipartite(int start , int v , ArrayList<ArrayList<Integer>> adj , int[] color) {
        // checking bipartite using BFS algo 
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int i : adj.get(node)) {
                if(color[i]==-1) {
                    color[i]=1-color[node];
                    q.add(i);
                } 
                else if(color[i]==color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean is_bipartite(int node , int col , int[] color , ArrayList<ArrayList<Integer>> adj) {
        //checking bipartite using DFS algo
        color[node]=col;
        for(int i : adj.get(node)) {
            if(color[i]==-1) {
                if(is_bipartite(i, 1-col, color, adj)==false) {
                    return false;
                }
                else if(color[i]==col) {
                    return false;
                }
            }
        }
        return true;
    }
}
