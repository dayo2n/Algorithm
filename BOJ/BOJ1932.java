package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1932 {
    static int [][] dp;
    static int [][] triangle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        triangle = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());

                // 가장 하단은 dp도 채워주기
                if (i == n-1)
                    dp[i][j] = triangle[i][j];
            }
        }

        for (int i=n-1-1; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int cur = triangle[i][j];
                dp[i][j] = cur + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}

/*
입력
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

출력
30
 */