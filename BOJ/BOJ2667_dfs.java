package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2667_dfs {
    static int[][] graph;
    static boolean [][] visited;
    static int N; // 정사각형 길이

    static void dfs(int row, int col, int building) {
        graph[row][col] = building;
        visited[row][col] = true;

        int [] updown = {-1, 1, 0, 0};
        int [] leftright = {0, 0, -1, 1};
        for (int i=0; i<updown.length; i++) {
            int newRow = row + updown[i];
            int newCol = col + leftright[i];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                if (graph[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    dfs(newRow, newCol, building);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            String [] input = br.readLine().split("");
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        int building = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, ++building);
                }
            }
        }
        int [] cnt = new int[building];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (graph[i][j] != 0) cnt[graph[i][j]-1]++;
            }
        }

        System.out.println(building);
        Arrays.sort(cnt);
        for (int val : cnt) {
            System.out.println(val);
        }
    }
}
