package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2573 {
    static int [][] map;
    static boolean [][] visited;
    static int [][] willMeltSoon;
    static int N, M, firstSeperatedYear;
    static StringBuilder sb;

    static boolean meltingIce() {

        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};
        boolean flag = false;
        willMeltSoon = new int[N][M];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {

                for (int i=0; i<4; i++) {
                    int newX1 = row + vertical[i];
                    int newY1 = col + horizon[i];
                    if (newX1 >= 0 && newX1 < N && newY1 >= 0 && newY1 < M) {
                        if (map[newX1][newY1] == 0) {
                            willMeltSoon[row][col]++;
                        }
                    }
                }
            }
        }
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                map[row][col] = (map[row][col] > willMeltSoon[row][col] ? map[row][col] - willMeltSoon[row][col] : 0);
                if (map[row][col] > 0) flag = true;
            }
        }
        return flag; // 전부 다 0이되면 false를 반환
    }

    static int countIceMountain() {
        visited = new boolean[N][M];
        int cnt = 0;

        // cnt가 2이상이면 분리된 상태
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (!visited[row][col] && map[row][col] > 0) {
                    cnt++;
                    dfs(row, col);
                }
            }
        }
        return cnt;
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;
        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};

        for (int i=0; i<4; i++) {
            int newX1 = row + vertical[i];
            int newY1 = col + horizon[i];

            if (newX1 >= 0 && newX1 < N && newY1 >= 0 && newY1 < M) {
                if (!visited[newX1][newY1] && map[newX1][newY1] > 0) {
                    dfs(newX1, newY1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            if (countIceMountain() > 1) break;

            firstSeperatedYear++;
            if (!meltingIce()) {
                firstSeperatedYear = 0;
                break;
            }
        }
        sb.append(firstSeperatedYear);
        System.out.println(sb);
    }
}

