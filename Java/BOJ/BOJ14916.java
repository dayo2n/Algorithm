package BOJ;

import java.util.Scanner;

public class BOJ14916 {
    static int [] dp;
    static int solve(int n){
        if (n == 2 || n == 5) return dp[n] = 1;
        else if (n == 1 || n == 3) return dp[n] = -1;

return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        System.out.println(solve(n));
    }
}
