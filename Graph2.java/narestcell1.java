import java.util.*;
public class narestcell1 {
    class three { //it stores in whoch cell (i,j) and it's nearest distance from a 1
       int f; //row
       int s; //col
       int t; //steps away from nearest 1
       public three(int f , int s , int t) {
        this.f=f;
        this.s=s;
        this.t=t;
       }
    }
    public static void main(String Args[]) {

    }
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<three> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    q.add(new three(i,j,0));
                    vis[i][j]=1;
                } else {
                    vis[i][j]=0;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()) {
            int row = q.peek().f;
            int col = q.peek().s;
            int steps = q.peek().t;
            q.remove();
            dist[row][col]=steps;
            for(int i=0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0) {
                    vis[nrow][ncol]=1;
                    q.add(new three(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
}
