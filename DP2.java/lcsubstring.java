import java.util.*;
public class lcsubstring {
    public static void main(String Args[]) {
      String str1 = "abcdgh";
      String str2 = "acdghr";
      int n = str1.length();
      int m = str2.length();
      System.out.println(lcs(str1, str2, n, m));
    }
    public static int lcs(String str1 , String str2 , int n , int m) { //tabulation
        // if(n==0 || m==0) { //BASE CASE
        //     return 0;
        // }
        n = str1.length();
        m = str2.length();
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        // int counter = 0;
        // if(str1.charAt(n-1) == str2.charAt(m-1)) {
        //    counter++;
        //     return lcs(str1,str2,n-1,m-1)+counter;
        // } else {
        //     counter=0;
        //     return lcs(str1,str2,n,m);
        // }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                  dp[i][j] = dp[i-1][j-1] + 1;
                  ans = Math.max(ans, dp[i][j]);
                } else { //different 
                    dp[i][j] = 0;
                }
            }
        }
       return ans;
    }
}
