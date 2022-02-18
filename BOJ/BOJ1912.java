package BOJ;

import java.io.*;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 1912,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 19))

public class BOJ1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] number = new int[n];
        int [] dp = new int[n];

        for (int idx = 0; idx < n; idx++) {
            number[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = number[idx];
        }

        int maxSum = dp[0];
        for (int idx = 1; idx < n; idx++) {
            dp[idx] = Math.max(number[idx], dp[idx-1] + number[idx]);
            if (dp[idx] > maxSum) maxSum = dp[idx];
        }
        System.out.println(maxSum);
    }
}
