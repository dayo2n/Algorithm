package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import annotation.*;
@BOJ(   number = 1655,
        tier = BaekjoonTier.GOLD_II,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 15))

public class BOJ1655 {
    static class MaxHeap {
        ArrayList <Integer> heap;
        MaxHeap () {
            heap = new ArrayList<>();
            heap.add(100_001);
        }

        void insert(int val){
            heap.add(val);
            int node = heap.size() - 1;

            while (node > 1 && heap.get(node) > heap.get(node / 2)) {
                int tmpVal = heap.get(node / 2);
                heap.set(node / 2, heap.get(node));
                heap.set(node, tmpVal);

                node = node / 2;
            }
        }

        void pop() {

            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int node = 1;
            while (node * 2 < heap.size()) {
                int left = node * 2;
                int right = node * 2 + 1;
                int max = left;

                if (right < heap.size() && heap.get(right) > heap.get(left)) {
                    max = right;
                }

                if (heap.get(max) < heap.get(node)) break;

                int tmpVal = heap.get(max);
                heap.set(max, heap.get(node));
                heap.set(node, tmpVal);
                node = max;
            }
        }

        int top() {
            if (heap.size() == 1) return -1; // 비어있는 경우
            return heap.get(1);
        }

        int size () {
            return heap.size() - 1;
        }
    }

    static class MinHeap {
        ArrayList <Integer> heap;
        MinHeap () {
            heap = new ArrayList<>();
            heap.add(0);
        }

        void insert(int val){
            heap.add(val);
            int node = heap.size() - 1;

            while (node > 1 && heap.get(node) < heap.get(node / 2)) {
                int tmpVal = heap.get(node / 2);
                heap.set(node / 2, heap.get(node));
                heap.set(node, tmpVal);

                node = node / 2;
            }
        }

        void pop() {

            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int node = 1;
            while (node * 2 < heap.size()) {
                int left = node * 2;
                int right = node * 2 + 1;
                int min = left;

                if (right < heap.size() && heap.get(right) < heap.get(left)) {
                    min = right;
                }

                if (heap.get(min) > heap.get(node)) break;

                int tmpVal = heap.get(min);
                heap.set(min, heap.get(node));
                heap.set(node, tmpVal);
                node = min;
            }
        }

        int top() {
            if (heap.size() == 1) return -1; // 비어있는 경우
            return heap.get(1);
        }

        int size() {
            return heap.size() - 1;
        }
    }

    static MaxHeap maxHeap;
    static MinHeap minHeap;

    static void swap() {
        int tmpMax = maxHeap.heap.get(1);
        int tmpMin = minHeap.heap.get(1);
        minHeap.pop();
        maxHeap.pop();
        minHeap.insert(tmpMax);
        maxHeap.insert(tmpMin);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();

        for (int i=0; i<N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) maxHeap.insert(next);
            else minHeap.insert(next);

            if (minHeap.size() > 0 && maxHeap.top() > minHeap.top()) swap();
            sb.append(maxHeap.top()).append("\n");
        }
        System.out.println(sb);
    }
}
