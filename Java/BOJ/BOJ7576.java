package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class RipenTomato {
    int x, y;
    RipenTomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ7576 {
    static int [][] tomato;
    static int [][] days;
    static int N, M;
    static int [] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    static void bfs(Queue<RipenTomato> queue) {
        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            for (int i=0; i<4; i++) {
                int newX = x + upDown[i];
                int newY = y + leftRight[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (days[newX][newY] == 0) {
                        days[newX][newY] = days[x][y] + 1;
                        queue.offer(new RipenTomato(newX, newY));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Queue<RipenTomato> queue = new LinkedList<>();

        tomato = new int[N][M];
        days = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                tomato[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (tomato[row][col] == 1) {
                    queue.add(new RipenTomato(row, col));
                    days[row][col] = 1;
                }
                if (tomato[row][col] == -1) days[row][col] = -1;
            }
        }

        bfs(queue);

        int maxDay = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (days[row][col] == 0) { // 하나라도 0이 있으면 모두 익지못하는 상황
                    System.out.println(-1);
                    return;
                }
                if (days[row][col] > maxDay) maxDay = days[row][col];
            }
        }
        System.out.println(maxDay - 1);
    }
}
