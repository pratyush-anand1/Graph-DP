import java.util.*;
public class rodcut {
    //it is a Unbounded knapsack problem(repeatation allowed)
    public static void main(String Args[]) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totRodlength = 8;
        System.out.println(rod_cut(length, price, totRodlength));
    }
    //weight->length , value->price,W->rodlength
    public static int rod_cut(int length[], int price[], int rodlength ) {
       int n = price.length;
       int[][] dp = new int[n+1][rodlength+1];
       //Initializing is not required since in java by default all entries are 0
       for(int i=1;i<n+1;i++) {
        for(int j=1;j<rodlength+1;j++) {
            if(length[i-1]<=rodlength) {
                //include
                int a = price[i-1] + dp[i-1][j-price[i-1]];
                //exclude
                int b = dp[i-1][j];
                dp[i][j] = Math.max(a, b);
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
       }
        return dp[n][rodlength];
    } 
}
