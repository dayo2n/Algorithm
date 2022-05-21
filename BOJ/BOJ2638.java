package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
@BOJ(   number = 2638,
        tier = BaekjoonTier.GOLD_IV,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 2))
public class BOJ2638 {
    static int [][] cheese, airCnt;
    static Queue<int []> queue;
    static boolean [][] visited;
    static int N, M, countCheese, hours, lastCheeseCnt;
    // hours: 치즈가 모두 녹는데 걸리는 시간
    // lastCheeseCnt: 치즈가 모두 녹기 한 시간 전에 남아있는 치즈조각의 칸의 개수
    static int [] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    // 고민이 필요한 부분: 치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정한다.
    static void bfs() {
        visited = new boolean[N][M];
        airCnt = new int[N][M];
        queue = new LinkedList<>();
        // 모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정되어 있으므로 (0,0)부터 시작
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i=0; i<4; i++) {
                int checkRow = x + upDown[i];
                int checkCol = y + leftRight[i];
                if (checkRow >= 0 && checkRow < N && checkCol >= 0 && checkCol < M) {

                    if (visited[checkRow][checkCol]) continue; // 방문 여부 확인해야함!

                    if (cheese[checkRow][checkCol] == 0) {
                        queue.offer(new int[]{checkRow, checkCol});
                        visited[checkRow][checkCol] = true;
                    } else { // 1이면
                        airCnt[checkRow][checkCol]++;
                        if (airCnt[checkRow][checkCol] > 1) {
                            cheese[checkRow][checkCol] = 0;
                            countCheese--;
                            visited[checkRow][checkCol] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        countCheese = 0;
        cheese = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                cheese[row][col] = Integer.parseInt(st.nextToken());
                if (cheese[row][col] == 1) countCheese++;
            }
        }
        hours = 0;
        while (countCheese > 0) {
            hours++;
            lastCheeseCnt = countCheese;
            bfs();
        }
        System.out.println(hours);
    }
}
