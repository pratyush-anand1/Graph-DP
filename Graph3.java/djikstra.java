import java.util.*;
//djikstra doesn't work for graph containing even single negative weight edge 
// since it will fall in an infinite loop 
// T.C = O(E logV)  worst case complexity
// pair = {dist,node}
// single source shortest path algo
//queue is not used because it traverses unneccessary paths or unrequired iteration which increases time complexity or it is not being greedy for minimal though it will give correct answer it is a brute force just checking all paths

public class djikstra {
    public static void main(String Args[]) {

    }

    class pair {
        int n; //node
        int d; //distance
        public pair(int d , int n) {
            this.n=n;
            this.d=d;
        }
    }
    public int[] djikstra_pq(int V , int src , ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y) -> x.d - y.d);
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new pair(0, src));
        while(pq.size()!=0) {
           int dis = pq.peek().d;
           int node = pq.peek().n;
           pq.remove();
           for(int i=0;i<adj.get(node).size();i++) {
            int edgewt = adj.get(node).get(i).get(1);
            int adjnode = adj.get(node).get(i).get(0);
            if(dis + edgewt < dist[adjnode]) {
              dist[adjnode] = dis + edgewt;
              pq.add(new pair(dist[adjnode], adjnode));
            }
           }
        }
       return dist;
    }

    public int[] djikstra_set() {
        // SET : stores data in ascending order i.e. smallest at the top
        // main AIM to use set is to erase already existing path
    }
}
