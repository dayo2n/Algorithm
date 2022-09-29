package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {
    static int N, M, ans;
    static int [][] map;
    static Queue<int []> queue;
    static final int BLANK = 0, WALL = 1, VIRUS = 2;
    static int [] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    // 벽을 세우자
    static void dfs (int row, int col, int cntWall) {
        if (cntWall == 3) {
            bfs();
            return;
        }

        for (int n = row; n <= N; n++) {
            for (int m = col; m <= M; m++) {
                if (map[n][m] == WALL) continue;
                map[n][m] = WALL;
                dfs(n, m + 1, cntWall + 1);
                map[n][m] = BLANK;
            }
            col = 1;
        }
    }

    // 벽을 세운 후 바이러스가 퍼진 개수를 세어보자
    static void bfs() {

        int [][] tempMap = new int[N + 1][M + 1];
        for (int n = 1; n <= N; n++) tempMap[n] = Arrays.copyOf(map[n], M + 1);
        Queue <int []> tempQueue = new LinkedList<>();
        Iterator it = queue.iterator();
        while (it.hasNext()) tempQueue.add((int[]) it.next());

        int cntVIRUS = 0;
        boolean [][] visited = new boolean[N + 1][M + 1];

        while (!tempQueue.isEmpty()) {
            int x = tempQueue.peek()[0];
            int y = tempQueue.peek()[1];
            tempQueue.poll();
            System.out.println("999");
            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int direction = 0; direction < 4; direction++) {
                int nx = x + upDown[direction];
                int ny = y + leftRight[direction];
                if (nx < 1 || nx > N || ny < 1 || ny > M || tempMap[nx][ny] == WALL) continue;
                tempMap[nx][ny] = VIRUS;
                cntVIRUS++;
                tempQueue.add(new int[] {nx, ny});
            }
        }
        if (ans > cntVIRUS) {
            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    System.out.print(tempMap[n][m] + " ");
                }
                System.out.println();
            }
        }
        System.out.println(cntVIRUS);
        ans = Math.min(ans, cntVIRUS);
        return;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        queue = new LinkedList<>();

        int cntBlank = 0;
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                if (map[n][m] == VIRUS) {
                    queue.add(new int[] {n, m});
                } else if (map[n][m] == BLANK) cntBlank++;
            }
        }
        ans = cntBlank;
        dfs(1, 1, 0);
        System.out.println(ans);
        System.out.println(cntBlank - ans);
    }
}
