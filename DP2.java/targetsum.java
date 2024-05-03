import java.util.*;
public class targetsum {
    public static boolean target_sum(int arr[] , int tar) { //tabulation or bootom-top
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][tar+1];
        //i = items & j = targetsum
        //dp[i][j] represents if i items of array gives subset sum==j ? T/F  meaning   
        /* Base cases or initialization
         * whenever targetsum=0 i.e j=0 every subset will satisfy it by empty set subset
         * So, wherever j=0 dp[i][j]=True
         * Another one is if we have i=0 i.e. no items and targetsum>0 then,
         * dp[0][j] = False where j>=1
         * In java by default all the entries of dp table is false
         * So we can initialize only the condition when j=0 by loops
         */
        for(int i=0;i<dp.length;i++) { //Initialization
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<tar+1;j++) {
                if(arr[i-1]<=tar) { //valid
                   //include
                   if(dp[i-1][j-arr[i-1]] == true) {
                    dp[i][j] = true;
                   }
                   //exclude
                   if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                   }
                }
            }
        }
        return dp[n][tar];
    }
    public static void main(String Args[]) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the size of array");
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // System.out.println("Enter the array elements");
        // for(int i=0;i<n;i++) {
        //     arr[i] = sc.nextInt();
        // }
        // System.out.println("Enter the target sum ");
        // int tar = sc.nextInt();
        // System.out.println(target_sum(arr, tar));
        int arr[] = {4,2,7,1,3};
        int tar = 20;
        System.out.println(target_sum(arr, tar));
    }
}
