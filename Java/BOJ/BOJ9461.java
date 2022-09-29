package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import annotation.*;
@BOJ(   number = 9461,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 25))

public class BOJ9461 {
    static int[] dp;
    static int P(int N) {
        if (N < 3) {
            return 1;
        }
        dp[0] = 1; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i < N; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }
        return dp[N-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N];
            System.out.println(P(N));
        }
    }
}
