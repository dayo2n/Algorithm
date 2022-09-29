package BOJ;

import java.util.Scanner;

public class BOJ2748 {

    static long[] dp = new long[91];

    public static long fibonacci(int n) {

        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (dp[n] != 0)
            return dp[n];

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }
}
