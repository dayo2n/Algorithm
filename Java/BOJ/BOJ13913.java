package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13913 {
    static int [] map, visited;
    static int N, K;
    static StringBuilder sb = new StringBuilder();
    static void bfs() {
        Queue <Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                sb.append(visited[K]).append("\n");
                queue.clear();
                int pre = K;
                while (pre != N) {
                    queue.add(pre);
                    System.out.println(pre);
                    pre = visited[pre];
                }
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    sb.append(queue.poll()).append(" ");
                }
                break;
            }

            for (int i=0; i<3; i++) {
                int [] movement = {-1, 1, cur};
                int newCur = cur + movement[i];
                if (newCur >= 0 && newCur < map.length) {
                    if (visited[newCur] == 0) {
                        visited[newCur] = visited[cur] + 1;
                        queue.add(newCur);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
        K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
        map = new int[100_001];
        visited = new int[100_001];
        bfs();
        System.out.println(sb);
    }
}
