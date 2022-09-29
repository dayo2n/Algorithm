package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 1149,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 18))

public class BOJ1149 {
    static int [][] dp;
    static int [][] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        cost = new int[N][3];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int rgb = 0; rgb < 3; rgb++) {
                cost[n][rgb] = Integer.parseInt(st.nextToken());
                if (n == 0) dp[n][rgb] = cost[n][rgb];
            }
        }

        for (int n = 1; n < N; n++) {
            dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + cost[n][0];
            dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + cost[n][1];
            dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + cost[n][2];
        }

        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}
