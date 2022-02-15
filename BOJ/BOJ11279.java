package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
@BOJ(   number = 11279,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 15))
public class BOJ11279 {
    private static class MaxHeap {
        private ArrayList<Integer> heap;
        MaxHeap () {
            heap = new ArrayList<>();
            heap.add(1_000_000); // 노드를 1부터 시작하기 위함
        }

        void insert(int node) {
            heap.add(node);
            int idx = heap.size() - 1;
            while (idx > 1 && heap.get(idx / 2) < heap.get(idx)) {
                // 자식노드가 부모노드보다 큰 값이면 swap
                int tmp = heap.get(idx / 2);
                heap.set(idx / 2, heap.get(idx));
                heap.set(idx, tmp);

                idx = idx / 2;
            }
        }

        int delete() {
            if (heap.size() - 1 < 1) {
                return 0;
            }
            int ret = heap.get(1);

            // 마지막 노드를 루트로 옮기고 정렬해준다
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int node = 1;
            while ((node * 2) < heap.size()) {

                // 왼쪽, 오른쪽 노드를 비교해서 누가 큰 지 구함
                int max = heap.get(getLeft(node));
                int maxNode = getLeft(node);
                if (getRight(node) < heap.size() && max < heap.get(getRight(node))) {
                    max = heap.get(getRight(node));
                    maxNode = getRight(node);
                }

                if (heap.get(node) > max) break;

                int tmp = heap.get(node);
                heap.set(node, heap.get(maxNode));
                heap.set(maxNode, tmp);
                node = maxNode;
            }
            return ret;
        }

        int getLeft(int node) {
            return node * 2;
        }

        int getRight(int node) {
            return node * 2 + 1;
        }
    }

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        MaxHeap heap = new MaxHeap();

        for (int n = 0; n < N; n++ ) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) sb.append(heap.delete()).append("\n");
            else heap.insert(cmd);
        }
        System.out.println(sb);
    }
}
