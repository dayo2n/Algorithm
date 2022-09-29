package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4485 {

    static int [][] cave, cost;
    static boolean [][] visited;
    static int [] moveRow = {-1, 1, 0, 0}, moveCol = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N, test_case = 0;
        Queue<int[]> queue = new LinkedList<>();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            cave = new int[N][N];
            cost = new int[N][N];
            visited = new boolean[N][N];
            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < N; col++) {
                    cave[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            queue.clear();
            queue.add(new int[]{0, 0});
            cost[0][0] = cave[0][0];

            while(!queue.isEmpty()) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();
                if (visited[x][y]) continue;
                visited[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = x + moveRow[i];
                    int ny = y + moveCol[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                    cost[nx][ny] += cave[x][y];
                    queue.add(new int[]{nx, ny});
                }
            }
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++)
                    System.out.print(cave[row][col] + " ");
                System.out.println();
            }
            sb.append("Problem ").append(test_case++).append(": ").append(cave[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }
}
