package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] line = new int[N + 1];
        int [] dp = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            line[n] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int n = 1; n <= N; n++) {
            dp[n] = 1;
            for (int i = 1; i <= N; i++) {
                if (line[i] < line[n] && dp[n] < dp[i] + 1) dp[n] = dp[i] + 1;

                if (cnt < dp[n]) cnt = dp[n];
            }
        }

        System.out.println(cnt == N ? N : N - cnt);
    }
}
