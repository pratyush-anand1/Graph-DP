import java.util.*;

// multiple source shortest path algorithm and also helps to detect negative cycle
//GO VIA EVERY VERTEX/NODE

//  min(dis[i][k] + dis[k][j]) this is reaching i->j via k so we make matrix foreach via node and use it for next via node
// we are using adjacencymatrix to store the cost between two nodes . for matrix whose edges don't exists initialize thier cost to infinity

// it is not much intutive as the other ones , it is more of a brute force where all combination of paths have been tried to get the shortest paths
//it is simple use of three for loops

// to detect a negative cycle if cost[i][i]<0 then there exists a negative cycle

//T.C->O(n^3)  S.C->O(n^2)

// we can even do djikstra for each node as src node instead of floyd warshall
// for each node djikstra time complexity will be O(V * (ElogV)) < O(n^3) {floyd warshall}
// but above is possible only for graphs not containing negative weights edges

public class floyd {
    public static void main(String Args[]) {

    }
    public void flyod_warshall(int[][] matrix) {
        int n = matrix.length;

        //
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==-1) { // there doesn't exists a edge in between i and j
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                if(i==j) matrix[i][j]=0;
            }
        }


      //floyd warshall
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        //negative cycle detection
        for(int i=0;i<n;i++) {
            if(matrix[i][i]<0) {
                System.out.println("NEGATIVE CYCLE EXISTS!!!");
            }
        }


        //if a node is not reachable set its matrix to -1
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==Integer.MAX_VALUE) {
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
