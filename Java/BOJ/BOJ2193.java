package BOJ;
import java.io.*;

import annotation.*;
@BOJ(   number = 2193,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 19))
public class BOJ2193 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] dp = new long[N + 2];
        dp[0] = 0;
        dp[1] = 1; // 0으로 시작하지 않으므로 1로만 시작할 수 있음
        dp[2] = 1; // 1이 연속으로 나타나지 않으므로 0만 올 수 있음
        for (int n = 3; n <= N; n++) {
            dp[n] = dp[n-1] + dp[n-2];
        }
        System.out.println(dp[N]);
    }
}

