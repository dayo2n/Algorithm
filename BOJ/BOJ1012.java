package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1012 {
    static int [][] garden;
    static boolean [][] visited;
    static int N, M;
    static StringBuilder sb;

    static void dfs(int row, int col) {
        visited[row][col] = true;
        if (garden[row][col] == 0) return;

        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};
        for (int i=0; i<4; i++) {
            int newX = row + vertical[i];
            int newY = col + horizon[i];
            if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                if (!visited[newX][newY]) dfs(newX, newY);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        for (int tc=0; tc<test_case; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            garden = new int[N][M];
            visited = new boolean[N][M];

            int cabbage = Integer.parseInt(st.nextToken());
            for (int i = 0; i<cabbage; i++) {
                st = new StringTokenizer(br.readLine());
                garden[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int cnt = 0;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (!visited[row][col] && garden[row][col] == 1) {
                        cnt++;
                        dfs(row, col);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
