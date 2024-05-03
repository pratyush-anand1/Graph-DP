import java.util.*; 
public class lcs {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the strings");
     String str1 = sc.next();
     String str2 = sc.next();
    //    String str1 = "abcde";
    //    String str2 = "ace";
       int n = str1.length();
       int m = str2.length();
       System.out.println(LCS1(str1, str2, n, m));
    }
    public static int LCS(String str1 , String str2 , int n , int m) { //recursion
        if(n==0 || m==0) return 0; //BASE CASE
        if(str1.charAt(n-1) == str2.charAt(m-1)) { //same char at n-1,m-1
            return LCS(str1, str2, n-1, m-1) + 1;
        } else { //different at n-1,m-1 positions
           int ans1 = LCS(str1, str2, n-1, m);
           int ans2 = LCS(str1, str2, n, m-1);
           return Math.max(ans1, ans2);
        }
    }
    public static int LCS1(String str1 , String str2 , int n , int m) { //Top-down
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                dp[i][j] = -1;
            }
        }

       
        if(n==0 || m==0) return 0; //Base Case
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) { //same
          dp[n][m] = LCS1(str1, str2, n-1, m-1) + 1;
          return dp[n][m];
        } else {
            int ans1 = LCS1(str1, str2, n-1, m);
           int ans2 = LCS1(str1, str2, n, m-1);
           dp[n][m] = Math.max(ans1,ans2);
           return dp[n][m];
        }
        
    }
    public static int LCS2(String str1 , String str2 , int n , int m) { //Bottom-up
        int[][] dp = new int[n+1][m+1];
        // for(int i=0;i<dp.length;i++) {
        //     dp[i][0] = 0;
        // } //this above step is by default all zero in java thats why we start with i=1 not 0
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
               //same
               if(str1.charAt(i-1) == str2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + 1;
               } else { //different change either str1 or str2 which gives it dp problem since we have overlapping subproblems 
                  int ans1 = dp[i-1][j]; // changing str1 length
                  int ans2 = dp[i][j-1]; //changing length of str2
                  dp[i][j] = Math.max(ans1,ans2);
               }
            }
        }
        return dp[n][m];
    }
}
