package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int vertex, edge;
    static LinkedList<Integer>[] graph;
    static boolean [] visited;

    static void dfs(int vertex) {
        visited[vertex] = true;
        if (graph[vertex].isEmpty()) return;

        int size = graph[vertex].size();
        for (int i=0; i<size; i++) {
            int tmpVertex = graph[vertex].poll();
            if (!visited[tmpVertex]) dfs(tmpVertex);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        graph = new LinkedList[vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i=1; i<=vertex; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int e = 0; e < edge; e++) {
            st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken());
            int tail = Integer.parseInt(st.nextToken());
            graph[head].add(tail);
            graph[tail].add(head);
        }
        int cnt = 0;

        for (int v = 1; v <= vertex; v++) {
            if (!visited[v]) {
                cnt++;
                dfs(v);
            }
        }
        System.out.println(cnt);
    }
}
