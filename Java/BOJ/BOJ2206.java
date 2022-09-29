package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.*;
import java.util.*;
@BOJ(   number = 2206,
        tier = BaekjoonTier.GOLD_IV,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 4))
public class BOJ2206 {
    static int N, M;
    static int [][] map;
    static int [][][] distance;
    static int [] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    static void bfs() {
        // 출발지점인 좌상 좌표 (1, 1)과 우하 좌표 (N, M)은 항상 0이라고 가정
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});

        distance = new int[N][M][2]; // 경로의 칸의 수를 저장
        // 3차원 배열 0이면 부수지않고 이동, 1이면 부수고 이동

        // 생각해보아야 할 점 : 벽 하나를 부수는 경우는 어떻게? 브루트포스?
        // 시간제한은 2초 => 3차원 배열을 이용하여 시간복잡도 O(1)로 만들어보자
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int wall = queue.peek()[2];
            System.out.println(x + " " + y + " " + wall + " " + distance[x][y][wall]);
            queue.poll();
            if (x == N - 1 && y == M - 1) return;

            for (int i=0; i<4; i++) {
                int newX = x + upDown[i];
                int newY = y + leftRight[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (distance[newX][newY][wall] > 0) continue;
                    if (map[newX][newY] == 0) {
                        queue.offer(new int[] {newX, newY, wall});
                        distance[newX][newY][wall] = distance[x][y][wall] + 1;
                    }
                    if (map[newX][newY] == 1 && wall == 0) {
                        queue.offer(new int[] {newX, newY, 1});
                        distance[newX][newY][1] = distance[x][y][wall] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int n = 0; n < N; n++) {
            String input = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = input.charAt(m) - '0';
            }
        }

        int res;
        if (N == 1 && M == 1) {
            res = 1;
            System.out.println(res);
            return;
        }

        bfs();
        int resDidNotCrashWall = distance[N-1][M-1][0];
        int resForCrashWall = distance[N-1][M-1][1];
        System.out.println(resDidNotCrashWall + " " + resForCrashWall);
        if (resDidNotCrashWall == 0)  res = resForCrashWall;
        else if (resForCrashWall == 0) res = resDidNotCrashWall;
        else res = Math.max(resForCrashWall, resDidNotCrashWall);

        System.out.println(res == 0 ? -1 : res + 1);
    }
}
