package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12851 {
    static int [] map;
    static boolean [] visited;
    static int N, K, cnt, ansTime;
    static void bfs() {
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});

        while (!queue.isEmpty()) {
            int cur = queue.peek()[0];
            int curTime = queue.peek()[1];
            queue.poll();

            visited[cur] = true;

            if (cur == K) {
                if (cnt == 0) { // 처음으로 동생에게 도착
                    ansTime = curTime;
                    cnt++;
                } else {
                    if (curTime == ansTime)
                        cnt++;
                }
            }

            for (int i=0; i<3; i++) {
                int [] movement = {-1, 1, cur};
                int newCur = cur + movement[i];
                if (newCur >= 0 && newCur < map.length) {
                    if (!visited[newCur]) {
                        queue.add(new int[]{newCur, curTime + 1});
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
        cnt = 0;
        map = new int[100_001];
        visited = new boolean[100_001];
        bfs();
        System.out.println(ansTime);
        System.out.println(cnt);
    }
}
