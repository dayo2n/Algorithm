package BOJ;

import java.io.*;
import java.util.*;
public class BOJ2583 {
    static int[][] graph;
    static int M, N, K, cnt;
    static boolean [][] visited;

    // 입력으로 받은 그림에 대한 이차원 배열을 생성
    static void drawRectangle(int lbx, int lby, int rtx, int rty) {
        for (int row = lbx; row < rtx; row++) {
            for (int col = lby; col < rty; col++) {
                graph[row][col] = 1;
            }
        }
    }

    // dfs 방식으로 영역 분리 / 표시
    static void dfs(int row, int col) {
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        // 각 영역을 번호로 구분해주도록 하기 위해 값을 초기화
        graph[row][col] = cnt + 1;  // 2부터 인덱싱

        int [] updown = {-1, 1, 0, 0};
        int [] leftright = {0, 0, -1, 1};
        for (int i=0; i<4; i++) {
            int newX = row + updown[i];
            int newY = col + leftright[i];
            if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                if (graph[newX][newY] == 0) {
                    dfs(newX, newY);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int left_bottom_x = Integer.parseInt(st.nextToken()); // 왼쪽 아래 꼭짓점 x 좌표
            int left_bottom_y = Integer.parseInt(st.nextToken()); // 왼쪽 아래 꼭짓점 y 좌표
            int right_top_x = Integer.parseInt(st.nextToken()); // 오른쪽 위 꼭짓점 x 좌표
            int right_top_y = Integer.parseInt(st.nextToken()); // 외른쪽 위 꼭짓점 y 좌표
            drawRectangle(left_bottom_x, left_bottom_y, right_top_x, right_top_y);
        }

        cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        // 각 영역의 사이즈를 구해준다ㅣ.
        int [] size = new int[cnt + 1 + 1];
        for (int i=0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                if (graph[i][j] == 0 || graph[i][j] == 1) continue;
                size[graph[i][j]]++;
            }
        }

        System.out.println(cnt);
        Arrays.sort(size);
        for (int i=2; i<size.length; i++)
            System.out.print(size[i] + " ");
    }
}
