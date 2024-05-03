import java.util.*;
// step1: find the order of toposort



public class shortestpathdag {

    class pair {
        int f; //neighnour node
        int s; //weight of the edge connecting with that node
        public pair(int f , int s) {
            this.f=f;
            this.s=s;
        }
    }
    public static void main(String Args[]) {

    }

    public static void dfs(int node , int[] vis , ArrayList<ArrayList<Integer>> adj , Stack<Integer> st) {
        vis[node]=1;
        for(int i : adj.get(node)) {
          if(vis[i]==0) {
            dfs(i, vis, adj, st);
          }
          st.push(node);
        }
    }


    public int[] shortest_distance_DAG(int n , int m , int[][] edges) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ArrayList<pair> temp = new ArrayList<pair>();
            adj.add(temp);
        }
        for(int i=0;i<n;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new pair(v, w));
        }
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++) {
            if(vis[i]==0) {
                dfs(i, vis, null, st);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0; //source or starting point
        while(!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++) {
                int v = adj.get(node).get(i).f;
                int w = adj.get(node).get(i).s;
                if(dist[node]+w < dist[v]) {
                    dist[v] = dist[node]+w;
                }
            }
        }
        return dist;
    }
}
