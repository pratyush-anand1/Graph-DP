import java.util.*;
public class fibonacci{
    public static void main(String Args []) {
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the number");
       int n = sc.nextInt();
       int[] f = new int[n+1];
       System.out.println(fib1(n,f));
    }
    public static int fib(int n , int f[]) { //Top-down approach(memoization)
        if(n==0 || n==1) {
            return n;
        }
        if(f[n] != 0) { //fib(n) is already claculated and stored
            return f[n];
        }
        f[n] = fib(n-1,f) + fib(n-2,f);
        return f[n];
    }
    public static int fib1(int n , int f[]) { //Bootom-Up(tabulation)
        f[0] = 0;
        f[1] =1;
        for(int i=2;i<=f.length;i++) { // small-large the values are calculated

            f[i] = f[i-1] + f[i-2];
        } // it is not recursion it is loops
        return f[n];
    }
}
//it would have taken O(2^n) if we had done it by recursion but with DP it takes O(n)
//By storing value in f array and using this we call it memoization and we can also ude dp[] array instead of f
//by recursion it forms complete Binary tree but by DP it forms skewed tree
//DP is optimized recursion
/* bottom-up(tabulation) steps
 * 1) create table and initialize according to base case
 * 2) meaning of each index in the table
 * 3) fill the table (from small to large index)
 */
/* it's always better to use tabulation rather than memoization because in meoization
 there can be a stack overflow problem as it uses  upgraded recursion*/ 