package BOJ;

import java.io.*;
public class BOJ10026 {
    static char [][] paint;
    static boolean [][] visitedBlindness;
    static boolean [][] visited;
    static int N;
    static StringBuilder sb;

    static void dfs(int row, int col, char color) {
        if (paint[row][col] != color) return;

        visited[row][col] = true;

        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};

        for (int i=0; i<4; i++) {
            int newX1 = row + vertical[i];
            int newY1 = col + horizon[i];

            if (newX1 >= 0 && newX1 < N && newY1 >= 0 && newY1 < N) {
                if (!visited[newX1][newY1])
                    dfs(newX1, newY1, color);
            }
        }
    }
    static void dfsForBlind(int row, int col, char [] color) {
        boolean isDifferentColor = true;
        for (int i=0; i<color.length; i++) {
            if (paint[row][col] == 'R' || paint[row][col] == 'G') {
                if (color[i] == 'R'|| color[i] == 'G') isDifferentColor = false;
            }
            else if (paint[row][col] == 'B' && color[i] == 'B') isDifferentColor = false;
        }
        if (isDifferentColor) return;

        visitedBlindness[row][col] = true;

        int [] vertical = {-1, 1, 0, 0};
        int [] horizon = {0, 0, -1, 1};

        for (int i=0; i<4; i++) {
            int newX1 = row + vertical[i];
            int newY1 = col + horizon[i];

            if (newX1 >= 0 && newX1 < N && newY1 >= 0 && newY1 < N) {
                if (!visitedBlindness[newX1][newY1])
                    dfsForBlind(newX1, newY1, color);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        paint = new char[N][N];
        visited = new boolean[N][N];
        visitedBlindness = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<N; j++) {
                paint[i][j] = input.charAt(j);
            }
        }

        int cnt = 0;
        int cntBlindness = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    ++cnt;
                    dfs(i, j, paint[i][j]);
                }
                if (!visitedBlindness[i][j]) {
                    ++cntBlindness;
                    if (paint[i][j] == 'B') dfsForBlind(i, j, new char[]{paint[i][j]});
                    else dfsForBlind(i, j, new char[]{'R', 'G'});
                }
            }
        }
        sb.append(cnt).append(" ").append(cntBlindness);
        System.out.println(sb);
    }
}
