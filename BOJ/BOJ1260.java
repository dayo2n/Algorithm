package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    static LinkedList<Integer>[] graph;
    static StringBuilder dfsSb, bfsSb;
    static boolean [] visitedDfs, visitedBfs;

    static void dfs(int vertex){
        if (visitedDfs[vertex]) return;
        visitedDfs[vertex] = true;
        dfsSb.append(vertex).append(" ");

        for (int nextVertex : graph[vertex]) {
            dfs(nextVertex);
        }
    }
    static void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);

        while(!queue.isEmpty()) {
            vertex = queue.poll();

            if (visitedBfs[vertex]) continue;

            visitedBfs[vertex] = true;
            bfsSb.append(vertex).append(" ");

            for (int nextVertex: graph[vertex]) queue.add(nextVertex);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
        graph = new LinkedList[N + 1];

        for (int i=1; i<=N; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken());
            int tail = Integer.parseInt(st.nextToken());

            graph[head].add(tail);
            graph[tail].add(head);

            Collections.sort(graph[head]);
            Collections.sort(graph[tail]);
        }

        dfsSb = new StringBuilder();
        bfsSb = new StringBuilder();
        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        dfs(V);
        bfs(V);
        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }
}
