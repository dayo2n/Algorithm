package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11437 {

    static int N, M;
    static StringBuilder sb;
    static int [] parent, depth;
    static LinkedList<Integer> [] tree;

    static void getDepth(int node, int height, int p) {
        depth[node] = height;
        parent[node] = p;
        for (int next: tree[node]) {
            if (next != p) getDepth(next, height+1, node);
        }
    }

    static int LCA(int v1, int v2) {
        int v1Height = depth[v1];
        int v2Height = depth[v2];

        // 노드 깊이가 맞춰줌
        while (v1Height > v2Height) {
            v1 = parent[v1];
            v1Height--;
        }

        while (v2Height > v1Height) {
            v2 = parent[v2];
            v2Height--;
        }

        while (v1 != v2) {
            v1 = parent[v1];
            v2 = parent[v2];
        }

        return v1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        tree = new LinkedList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];

        for (int n = 0; n <= N; n++) tree[n] = new LinkedList<>();

        for (int n = 1; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken());
            int tail = Integer.parseInt(st.nextToken());
            tree[head].add(tail);
            tree[tail].add(head);
        }

        // 루트는 항상 1
        getDepth(1, 1, 0);

        M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            sb.append(LCA(v1, v2)).append("\n");
        }
        System.out.println(sb);
    }
}
