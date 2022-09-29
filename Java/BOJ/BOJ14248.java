package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14248 {
    static int [] stoneBridge;
    static boolean [] visited;
    static int N, cnt; // 돌다리 개수, 건널 수 있는 돌다리의 개수

    static void dfs(int node) {
        if (!visited[node]) cnt++;
        visited[node] = true;

        if (node - stoneBridge[node] > 0) dfs(node - stoneBridge[node]);
        if (node + stoneBridge[node] <= N) dfs(node + stoneBridge[node]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stoneBridge = new int[N + 1];
        visited = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            stoneBridge[i] = Integer.parseInt(st.nextToken());
        }
        dfs(Integer.parseInt(br.readLine()));
        System.out.println(cnt);
    }
}
