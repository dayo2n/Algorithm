package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int [][] safezone;
    static boolean [][] visited;
    static int N, maxCnt, theHeight;
    static int [] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    static void dfs(int row, int col, int rainHeight) {
        if (visited[row][col]) return;

        visited[row][col] = true;

        for (int i=0; i<4; i++) {
            int newRow = row + upDown[i];
            int newCol = col + leftRight[i];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                if (safezone[row][col] > rainHeight) {
                    dfs(newRow, newCol, rainHeight);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        safezone = new int[N][N];
        visited = new boolean[N][N];
        int maxRain = 0;
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                safezone[row][col] = Integer.parseInt(st.nextToken());
                if (maxRain < safezone[row][col]) maxRain = safezone[row][col];
            }
        }

        maxCnt = 0;
        theHeight = 0;
        for (int rain = 0; rain < maxRain; rain++) {

            int cnt = 0; // rain만큼 비가 왔을때 안전한 영역의 개수
            visited = new boolean[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (safezone[row][col] > rain && !visited[row][col]) {
                        cnt++;
                        dfs(row, col, rain);
                    }
                }
            }
            if (cnt > maxCnt) maxCnt = cnt;
        }
        System.out.println(maxCnt);
    }
}
