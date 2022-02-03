package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    static int [][] grid, dp;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 표의 크기 (N * N)
        int M = Integer.parseInt(st.nextToken()); // 구간 합을 구해야 하는 횟수
        sb = new StringBuilder();

        grid = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if ( i==1 && j==1 ) {
                    dp[1][1] = grid[1][1];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else // i > 0 && j > 0
                    dp[i][j] = grid[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 == x2 && y1 == y2)
                sb.append(grid[x1][y1]).append("\n");
            else
                sb.append(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1]  + dp[x1-1][y1-1]).append("\n");
        }
        System.out.println(sb);
    }
}
