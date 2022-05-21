package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
@BOJ(   number = 3584,
        tier = BaekjoonTier.GOLD_IV,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 10))
public class BOJ3584 {
    static LinkedList<Integer> [] tree;
    static int [] parent, depth;
    static boolean [] hasChild;

    static int LCA(int v1, int v2) {
        int v1Height = depth[v1];
        int v2Height = depth[v2];

        while (v1Height < v2Height) {
            v2 = parent[v2];
            v2Height--;
        }

        while (v1Height > v2Height) {
            v1 = parent[v1];
            v1Height--;
        }

        while (v1 != v2) {
            v1 = parent[v1];
            v2 = parent[v2];
        }
        return v1;
    }

    static void setDepth(int cur, int height, int pa) {
        depth[cur] = height;
        parent[cur] = pa;
        for (int next : tree[cur]) {
            if (next != pa) setDepth(next, height + 1, cur);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 0; test_case < t; test_case++) {
            int N = Integer.parseInt(br.readLine());
            tree = new LinkedList[N + 1];
            parent = new int[N + 1];
            depth = new int[N + 1];
            hasChild = new boolean[N + 1];

            for (int vertex = 0; vertex <= N; vertex++) {
                tree[vertex] = new LinkedList<>();
            }

            for (int edge = 0; edge < N - 1; edge++) {
                st = new StringTokenizer(br.readLine());
                int head = Integer.parseInt(st.nextToken());
                int tail = Integer.parseInt(st.nextToken());
                tree[head].add(tail);
                tree[tail].add(head);
                hasChild[tail] = true;
            }

            int rootNode = 0;
            // 자식이 없는 노드를 루트로 지정
            for (int b = 1; b <= N; b++)  {
                if (!hasChild[b]) {
                    rootNode = b;
                    break;
                }
            }
            setDepth(rootNode, 1, 0);

            // 마지막 줄에는 공통조상을 구할 두 노드가 주어짐
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            sb.append(LCA(v1, v2)).append("\n");
        }
        System.out.println(sb);
    }
}
