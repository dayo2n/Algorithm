package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
@BOJ(   number = 1927,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 15))
public class BOJ1927 {
    private static class MinHeap {
        private ArrayList<Integer> heap;
        MinHeap () {
            heap = new ArrayList<>();
            heap.add(0); // 노드의 인덱스를 1부터 시작하기 위함
        }

        void insert(int value) {
            heap.add(value);
            int idx = heap.size() - 1;

            while (idx > 1 && heap.get(idx / 2) > heap.get(idx)) {
                int tmpVal = heap.get(idx / 2);
                heap.set(idx / 2, heap.get(idx));
                heap.set(idx, tmpVal);

                idx = idx / 2;
            }
        }

        int delete() {

            if (heap.size() - 1 < 1) {
                return 0;
            }

            int ret = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int node = 1;
            while ((node * 2) < heap.size()) {
                int left = node * 2;
                int right = node * 2 + 1;

                int min = left;
                if (right < heap.size()) {
                    if (heap.get(right) < heap.get(left)) {
                        min = right;
                    }
                }

                if (heap.get(node) < heap.get(min)) break;

                int tmpVal = heap.get(node);
                heap.set(node, heap.get(min));
                heap.set(min, tmpVal);

                node = min;
            }
            return ret;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MinHeap heap = new MinHeap();
        for (int n = 0; n < N; n++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) sb.append(heap.delete()).append("\n");
            else heap.insert(cmd);

        }
        System.out.println(sb);
    }
}
