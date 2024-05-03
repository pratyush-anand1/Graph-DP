import java.lang.reflect.Array;
import java.util.*;
//toposort but usinf BFS instead of DFS
//step 1: create indegree arrayfor all vertices
//step 2: insert all nodes into queue whose indegree is 0
//step 3: take them out of queue and reduce the indegree of adjacent nodes by 1


public class kahns {
    public static void main(String Args[]) {

    }
    public static int[] toposort(int V , ArrayList<ArrayList<Integer>> adj) { //BFS use
        int[] indegree = new int[V];
        for(int i=0;i<V;i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int j=0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[j++] = node;
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it]==0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
