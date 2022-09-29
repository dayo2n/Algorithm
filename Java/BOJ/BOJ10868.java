package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class segmentTree {
    // 구간에 대한 질문에 효율적으로 답을 구할 수 있는 자료구조
    // 시간 복잡도 O(logN)

    long segmentArr[];

    public segmentTree(int[] arr, int arrSize) {
        this.segmentArr = new long[arrSize];
    }

    // 세그먼트 트리를 초기화
    // 어떤 값을 구할 지에 따라 init의 return 방법이 달라짐, 아래는 최솟값을 구하는 경우

    // arr: 입력배열, left : 노드 시작 번호, end : 노드 끝 번호, node : 노드번호
    long init(int[] arr, long[] segmentArr, int start, int end, int node) {
        // leap node
        if (start == end)
            return segmentArr[node] = arr[start];
        int mid = (start + end) / 2;
        return segmentArr[node] = Math.min(init(arr, segmentArr, start, mid, node * 2),
                init(arr, segmentArr, mid + 1, end, node * 2 + 1));
    }

    long min(long[] segArr, int node, int start, int end, int left, int right) {
        // 구간 최솟값을 구하고자하는 범위와 상관이 없는 경우
        if (left > end || right < start)
            return Integer.MAX_VALUE;
        // [start, end]가 [left, right]를 완전히 포함
        if (left <= start && right >= end)
            return segmentArr[node];
        int mid = (start + end) / 2;

        // 구하고자하는 구간이 [start, end]를 완전히 포함하는 경우
        return Math.min(min(segArr, node * 2, start, mid, left, right),
                min(segArr, node * 2 + 1, mid + 1, end, left, right));
    }
}

public class BOJ10868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n + 1];

        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());

        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = (int) Math.pow(2, x) * 2;
        segmentTree segTree = new segmentTree(num, size);

        segTree.init(num, segTree.segmentArr, 0, n - 1, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(segTree.min(segTree.segmentArr, 1, 0, n - 1, from - 1, to - 1) + "\n");
        }
        System.out.println(sb);
    }
}
