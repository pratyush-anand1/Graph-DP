import java.util.*;
//DETECTING A CYCLE IN DIRECTED GRAPH USING DFS
//WE CAN'T USE PREVIOUS ALGORITHM SINCE EVEN FOR A NON CYCLE IT WILL GIVE A CYCLIC OUTPUT
// MAIN AGENDA : ON THE SAME PATH NODE HAS TO BE VISITED
// T.C= O(V+E)    S.C= O(2n)


public class detectcycledir {
    public static void main(String Args[]) {
      Scanner sc = new Scanner(System.in);
      int V = sc.nextInt();
      int[] vis = new int[V];
      int[] pathvis=new int[V];
      for(int i=0;i<V;i++) {
        if(vis[i]==0) {
            if(dfscheck(i,adj, vis, pathvis)==true) {
                System.out.println(true);
            }
        }
      }
    }
    public static  boolean dfscheck(int node , ArrayList<ArrayList<Integer>> adj,int[] vis,int[] pathvis) {
        vis[node]=1;
        pathvis[node]=1;
        //traverse for adjacent nodes
        for(int i : adj.get(node)) {
            if(vis[i]==0) {
                if(dfscheck(i, adj, vis, pathvis)==true) {
                    return true;
                }
                else if(pathvis[i]==1) {
                    return true;
                }
            }
        }
        pathvis[node]=0;
        return false;
    }
}
