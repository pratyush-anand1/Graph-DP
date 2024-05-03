import java.util.*;

//linear ordering of vertices such that if there is an edge between u & v then u appears before v in that ordering

public class topodfsstriver {
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
    public static int[] toposort(int V , ArrayList<ArrayList<Integer>> adj) {
        int[] vis= new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++) {
            if(vis[i]==0) {
                dfs(i, vis, adj, st);
            }
        }
        int[] ans = new int[V];
        int j=0;
        while(!st.isEmpty()) {
            ans[j++]=st.peek();
            st.pop();
        }
        return ans;
    }
}
