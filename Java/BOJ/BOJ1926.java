package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1926 {
    static int [][] map;
    static boolean [][] visited;
    static int n, m, maxSize, tmpSize;
    static StringBuilder sb;

    static void dfs(int row, int col) {
        visited[row][col] = true;


        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};

        for (int i=0; i<4; i++) {
            int newX1 = row + vertical[i];
            int newY1 = col + horizon[i];

            if (newX1 >= 0 && newX1 < n && newY1 >= 0 && newY1 < m) {
                if (!visited[newX1][newY1] && map[newX1][newY1] == 1) {
                    ++tmpSize;
                    if (maxSize < tmpSize) maxSize = tmpSize;
                    dfs(newX1, newY1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        maxSize = 0;
        tmpSize = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && map[row][col] == 1) {
                    cnt++;
                    tmpSize = 1;
                    if (maxSize < tmpSize) maxSize = tmpSize;
                    dfs(row, col);
                } else
                    tmpSize = 0;
            }
        }
        sb.append(cnt).append("\n").append(maxSize);
        System.out.println(sb);
    }
}
