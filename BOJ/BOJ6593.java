package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {
    static int L, R, C;
    static boolean flag;
    static int [][][] time;
    static StringBuilder sb;
    static char [][][] building;
    static boolean [][][] visited;
    static final char START = 'S', ESCAPE = 'E', GOLD = '#', VACANT = '.';
    static int [] upDown = {-1, 1, 0, 0, 0, 0}, northSouth = {0, 0, -1 ,1, 0, 0}, westEast = {0, 0, 0, 0, -1, 1};

    static void bfs(Queue<int []> queue) {
        while (!queue.isEmpty()) {
            int l = queue.peek()[0];
            int r = queue.peek()[1];
            int c = queue.peek()[2];
            queue.poll();
            if (building[l][r][c] == ESCAPE) {
                sb.append("Escaped in ").append(time[l][r][c]).append(" minute(s).\n");
                flag = true;
                break;
            }

            for (int i = 0; i<6; i++) {
                int newLayer = l + upDown[i];
                int newRow = r + northSouth[i];
                int newColumn = c + westEast[i];
                if (newLayer < 0 || newLayer >= L || newRow < 0 || newRow >= R || newColumn < 0 || newColumn >= C) continue;
                if (visited[newLayer][newRow][newColumn]) continue;
                visited[newLayer][newRow][newColumn] = true;
                if (building[newLayer][newRow][newColumn] == VACANT || building[newLayer][newRow][newColumn] == ESCAPE) {
                    time[newLayer][newRow][newColumn] = time[l][r][c] + 1;
                    queue.add(new int[] {newLayer, newRow, newColumn});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        String trashLine;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 빌딩의 층 수
            R = Integer.parseInt(st.nextToken()); // 한 층의 행 개수
            C = Integer.parseInt(st.nextToken()); // 한 층의 열 개수
            if (L == 0 && R == 0 && C == 0) break;

            flag = false;
            Queue<int[]> queue = new LinkedList<>();
            time = new int[L][R][C];
            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            for (int l = 0; l < L; l++) {
                if (l != 0) {
                    trashLine = br.readLine();
                }
                for (int r = 0; r < R; r++) {
                    String layer = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = layer.charAt(c);
                        if (building[l][r][c] == START) {
                            queue.add(new int[] {l, r, c});
                            visited[l][r][c] = true;
                        }
                    }
                }
            }
            trashLine = br.readLine();
            bfs(queue);
            if (!flag) sb.append("Trapped!").append("\n");
        }
        System.out.println(sb);
    }
}
