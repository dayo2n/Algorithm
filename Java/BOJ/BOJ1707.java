package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

@BOJ(   number = 1707,
        tier = BaekjoonTier.GOLD_IV,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 11))

public class BOJ1707 {
    static int V, E;
    static LinkedList<Integer> [] graph;
    static int [] group; // 같은 집합에 속하는지
    static StringBuilder sb;
    static boolean YesNo;

    static void grouping(int node, int groupId) {
        group[node] = groupId;

        for (int next : graph[node]) {
            if (group[next] == 0) { // 방문하지 않은 경우
                grouping(next, -groupId);
            }
            else if (group[next] == group[node]) {
                YesNo = false;
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < K; test_case++) {
            YesNo = true;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // number of vertex
            E = Integer.parseInt(st.nextToken()); // number of edge

            graph = new LinkedList[V + 1];
            group = new int[V + 1]; // 집합은 -1 또는 1, 0은 방문하지 않은 노드
            for (int v = 0; v <= V; v++) graph[v] = new LinkedList<>();
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int head = Integer.parseInt(st.nextToken());
                int tail = Integer.parseInt(st.nextToken());
                graph[head].add(tail);
                graph[tail].add(head);
            }
            for (int v = 1; v <= V; v++) {
                if (group[v] == 0) grouping(v, 1);
            }
            sb.append(YesNo ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
