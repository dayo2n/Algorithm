package BOJ;

import java.io.*;
import java.util.StringTokenizer;
public class BOJ4677 {
    static char [][] map;
    static boolean [][] visited;
    static int [][] cnt;
    static int N, M;
    static final char OIL = '@';
    static final char ABSENCE = '*';
    static StringBuilder sb;

    static void dfs(int row, int col) {
        visited[row][col] = true;
        if (map[row][col] == ABSENCE) return;

        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};
        int [][] diagonal = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i=0; i<4; i++) {
            int newX1 = row + vertical[i];
            int newY1 = col + horizon[i];
            int newX2 = row + diagonal[i][0];
            int newY2 = col + diagonal[i][1];

            if (newX1 >= 0 && newX1 < N && newY1 >= 0 && newY1 < M) {
                if (!visited[newX1][newY1])
                    dfs(newX1, newY1);
            }
            if (newX2 >= 0 && newX2 < N && newY2 >= 0 && newY2 < M) {
                if (!visited[newX2][newY2])
                    dfs(newX2, newY2);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            map = new char[N][M];
            visited = new boolean[N][M];
            cnt = new int[N][M];

            for (int i=0; i<N; i++) {
                String input = br.readLine();
                for (int j=0; j<M; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            int space = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (!visited[i][j] && map[i][j] == OIL) {
                        ++space;
                        dfs(i, j);
                    }
                }
            }
            sb.append(space).append("\n");
        }
        System.out.println(sb);
    }
}
