package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ21736 {
    static char [][] map;
    static boolean [][] visited;
    static final char VACANT = 'O';
    static final char WALL = 'X';
    static final char DOYEON = 'I'; // only
    static final char PERSON = 'P';
    static int N, M, cnt;

    static void dfs(int row, int col) {
        visited[row][col] = true;
        if (map[row][col] == PERSON) cnt++;

        int [] upDown = {1, -1, 0, 0};
        int [] leftRight = {0, 0, -1, 1};
        for (int i=0; i<4; i++) {
            int newRow = row + upDown[i];
            int newCol = col + leftRight[i];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                if (!visited[newRow][newCol] && map[newRow][newCol] != WALL)
                    dfs(newRow, newCol);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 캠퍼스의 행 크기
        M = Integer.parseInt(st.nextToken()); // 캠퍼스의 열 크기
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        cnt = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (!visited[row][col] && map[row][col] == DOYEON) {
                    dfs(row, col);
                }
            }
        }
        System.out.println((cnt == 0) ? "TT" : cnt);
    }
}
