package BOJ;
import java.io.*;
import java.util.*;

class Tomato {
    int x, y, z;
    Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class BOJ7569 {
    static int [][][] tomato;
    static int [][][] days;
    static int N, M, H;
    static int [] upDown = {-1, 1, 0, 0, 0, 0}, leftRight = {0, 0, -1, 1, 0, 0}, frontRear = {0, 0, 0, 0, -1, 1};

    static void bfs(Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int z = queue.peek().z;
            queue.poll();

            for (int i=0; i<6; i++) {
                int newX = x + upDown[i];
                int newY = y + leftRight[i];
                int newZ = z + frontRear[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && newZ >= 0 && newZ < H) {
                    if (days[newX][newY][newZ] == 0) {
                        days[newX][newY][newZ] = days[x][y][z] + 1;
                        queue.offer(new Tomato(newX, newY, newZ));
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
        H = Integer.parseInt(st.nextToken());
        Queue<Tomato> queue = new LinkedList<>();

        tomato = new int[N][M][H];
        days = new int[N][M][H];

        for (int z = 0; z < H; z++) {
            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < M; col++) {
                    tomato[row][col][z] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for (int z = 0; z < H; z++) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (tomato[row][col][z] == 1) {
                        queue.add(new Tomato(row, col, z));
                        days[row][col][z] = 1;
                    }
                    if (tomato[row][col][z] == -1) days[row][col][z] = -1;
                }
            }
        }
        bfs(queue);

        int maxDay = 0;
        for (int z = 0; z < H; z++) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (days[row][col][z] == 0) { // 하나라도 0이 있으면 모두 익지못하는 상황
                        System.out.println(-1);
                        return;
                    }
                    if (days[row][col][z] > maxDay) maxDay = days[row][col][z];
                }
            }
        }
        System.out.println(maxDay - 1);
    }
}
