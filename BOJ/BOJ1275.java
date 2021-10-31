package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1275 {

    static int input[];
    static long tree[];
    static int n, q;

    static long init(int start, int end, int node) {
        if (start == end)
            return tree[node] = input[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static long sum(int node, int start, int end, int left, int right) {
        // 범위에서 밖에
        if (left > end || right < start)
            return 0;
        // 범위 안에
        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    // val : 대체할 값
    static long replace(int node, int start, int end, int idx, int val) {
        if (idx < start || idx > end)
            return tree[node];
        if (start == end)
            return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = replace(node * 2, start, mid, idx, val) + replace(node * 2 + 1, mid + 1, end, idx, val);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        input = new int[n + 1];// 구간합을 구해주는 세그먼트 트리에서는 인덱스를 1로 시작하기

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++)
            input[i] = Integer.parseInt(st.nextToken());

        tree = new long[4 * n];
        init(1, n, 1);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int X = Math.min(x, y);
            int Y = Math.max(x, y);
            sb.append(sum(1, 1, n, X, Y) + "\n");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            replace(1, 1, n, a, b);
        }

        System.out.println(sb);
    }
}
