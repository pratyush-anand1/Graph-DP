import java.util.*;
public class knapsack01{
    public static void main(String Args[]) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the size of value or weight array");
        int x = sc.nextInt();
        int[] val = new int[x];
        int[] wt = new int[x];
        System.out.println("Enter the max bag weight");
        int W = sc.nextInt();
        System.out.println("enter the value and weight array ");
        for(int i=0;i<x;i++) {
           val[i] = sc.nextInt();
          
        }
        for(int i=0;i<x;i++) {
           
           wt[i] = sc.nextInt();
        }
        System.out.println(knapsack(val, wt, W, x));
    }
    public static int knapsack(int val[] , int wt[] , int W , int n) { //recursion
        if(W==0 || n==0) { //n=index
            return 0;
        }
        if(wt[n-1]<= W) { //valid
            //include 
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, W, ans1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, n-1);
        }
    } //O(2^n) since every item has2 options to either include or exclude
    public static int knapsack1(int val[],int wt[],int W, int dp[][],int n) {//memoization
        if(W==0 || n==0) {
            return 0;
        }
        if(dp[n][W] != -1) { //already calculated
            return dp[n][W];
        }
        if(wt[n-1]<=W) {
            //include
            int ans1 = val[n-1] + knapsack1(val, wt, W-wt[n-1],dp, n-1);
            //exclude
            int ans2 = knapsack1(val, wt, W, dp,ans1);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            return knapsack1(val, wt, W,dp, n-1);
        }
        /* dp[i][j] means i items + j(W or knapsack size) 
         * will give how much maxProfit
         */
        public static int Knapsack2(int val[] , int wt[] , int W) { //Tabulation method
            int[][] dp = new int[val.length+1][W+1];
           for(int i=0;i<dp.length;i++) { //Initializing (Base Case type)
            dp[i][0] = 0; //0th column
           }
           for(int i=0;i<dp.length[0];i++) {
            dp[0][i] = 0; //0th row
           }
           for(int i=1;i<val.length+1;i++) {
              for(int j=0;j<W+1;j++) {
              int v = val[i-1]; //ith item value
              int wtt = wt[i-1]; //ith item weight
              if(w<=j) { //valid
                int p1 = v + dp[i-1][j-w]; //include
                int p2 = dp[i-1][j]; //exclude
                dp[i][j] = Math.min(p1, p2);
              } else {
                dp[i][j] = dp[i-1][j];
              }
              }
           }
           return dp[val.length][W]; //O(nW)
        }
    }
}
