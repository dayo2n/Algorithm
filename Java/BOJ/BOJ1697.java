package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int [] map;
    static int [] time;
    static int N, K;
    static void bfs() {
        Queue <Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) break;

            for (int i=0; i<3; i++) {
                int [] movement = {-1, 1, cur};
                int newCur = cur + movement[i];
                if (newCur >= 0 && newCur < map.length) {
                    if (time[newCur] == 0) {
                        time[newCur] = time[cur] + 1;
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
        time = new int[100_001];
        bfs();
        System.out.println(time[K]);
    }
}
