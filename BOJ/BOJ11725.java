package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11725 {
    static LinkedList<Integer>[] tree;
    static int [] ret;
    static boolean [] visited;

    static void dfs(int data) {
        visited[data] = true;

        for (int i=0; i<tree[data].size(); i++) {
            int next = tree[data].get(i);
            if (!visited[next]) {
                ret[next] = data;
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        tree = new LinkedList[N+1];
        visited = new boolean[N+1];
        ret = new int[N+1];
        for (int n=1; n<=N; n++) {
            tree[n] = new LinkedList<>();
        }

        for (int n=1; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree[parent].add(child);
            tree[child].add(parent);
        }
        dfs(1);
        for (int val=2; val<N+1; val++) {
            sb.append(ret[val]).append("\n");
        }
        System.out.println(sb);
    }
}
