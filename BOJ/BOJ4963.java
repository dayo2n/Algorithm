package BOJ;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    static int [][] map;
    static boolean [][] visited;
    static int w, h;
    static StringBuilder sb;

    static void dfs(int row, int col) {

        visited[row][col] = true;
        if (map[row][col] == 0) return;

        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};
        int [][] diagonal = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i=0; i<4; i++) {
            int newX1 = row + vertical[i];
            int newY1 = col + horizon[i];
            int newX2 = row + diagonal[i][0];
            int newY2 = col + diagonal[i][1];

            if (newX1 >= 0 && newX1 < h && newY1 >= 0 && newY1 < w) {
                if (!visited[newX1][newY1])
                    dfs(newX1, newY1);
            }
            if (newX2 >= 0 && newX2 < h && newY2 >= 0 && newY2 < w) {
                if (!visited[newX2][newY2])
                    dfs(newX2, newY2);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        ++cnt;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
