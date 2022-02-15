package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7662 {
    static class MinHeap {
        ArrayList<int []> minHeap;
        MinHeap () {
            minHeap = new ArrayList<>();
            minHeap.add(new int[] {Integer.MIN_VALUE, 0});
        }

        void insert(int [] val) {
            minHeap.add(val);
            int node = minHeap.size() - 1;

            while (node > 1 && minHeap.get(node)[0] < minHeap.get(node / 2)[0]) {
                int [] tmpVal = minHeap.get(node / 2);
                minHeap.set(node / 2, minHeap.get(node));
                minHeap.set(node, tmpVal);

                node = node / 2;
            }
        }

        boolean empty() {
            return (minHeap.size() == 1);
        }

        int [] getTop() {
            return minHeap.get(1);
        }

        int [] pop() {
            int [] ret = minHeap.get(minHeap.size() - 1);
            minHeap.set(1, minHeap.get(minHeap.size() - 1));
            minHeap.remove(minHeap.size() - 1);

            int node = 1;
            while (node * 2 < minHeap.size()) {
                int left = node * 2;
                int right = node * 2 + 1;
                int min = left;

                if (right < minHeap.size() && minHeap.get(right)[0] < minHeap.get(left)[0]) {
                    min = right;
                }

                if (minHeap.get(min)[0] > minHeap.get(node)[0]) break;

                int [] tmpVal = minHeap.get(min);
                minHeap.set(min, minHeap.get(node));
                minHeap.set(node, tmpVal);

                node = min;
            }

            return ret;
        }
    }

     static class MaxHeap {
        ArrayList<int []> maxHeap;
        MaxHeap () {
            maxHeap = new ArrayList<>();
            maxHeap.add(new int[] {Integer.MAX_VALUE, 0});
        }

        void insert(int [] val) {
            maxHeap.add(val);
            int node = maxHeap.size() - 1;

            while (node > 1 && maxHeap.get(node)[0] > maxHeap.get(node / 2)[0]) {
                int [] tmpVal = maxHeap.get(node / 2);
                maxHeap.set(node / 2, maxHeap.get(node));
                maxHeap.set(node, tmpVal);

                node = node / 2;
            }
        }

        boolean empty() {
            return (maxHeap.size() == 1);
        }

        int [] getTop() {
            return maxHeap.get(1);
        }

        int [] pop() {
            int [] ret = maxHeap.get(maxHeap.size() - 1);
            maxHeap.set(1, maxHeap.get(maxHeap.size() - 1));
            maxHeap.remove(maxHeap.size() - 1);

            int node = 1;
            while (node * 2 < maxHeap.size()) {
                int left = node * 2;
                int right = node * 2 + 1;
                int max = left;

                if (right < maxHeap.size() && maxHeap.get(right)[0] > maxHeap.get(left)[0]) {
                    max = right;
                }

                if (maxHeap.get(max)[0] < maxHeap.get(node)[0]) break;

                int [] tmpVal = maxHeap.get(max);
                maxHeap.set(max, maxHeap.get(node));
                maxHeap.set(node, tmpVal);
                node = max;
            }
            return ret;
        }
     }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        MinHeap minHeap;
        MaxHeap maxHeap;
        for (int test_case = 1; test_case <= T; test_case++) {
            int K = Integer.parseInt(br.readLine());
            minHeap = new MinHeap();
            maxHeap = new MaxHeap();
            boolean [] visited = new boolean[K];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int val = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case "I":
                        minHeap.insert(new int[] {val, k});
                        maxHeap.insert(new int[] {val, k});
                        visited[k] = true;
                        break;
                    case "D":
                        if (val == 1) { // 최댓값 삭제
                            while (!maxHeap.empty() && !visited[maxHeap.getTop()[1]]) maxHeap.pop();
                            if (!maxHeap.empty()) {
                                visited[maxHeap.getTop()[1]] = false;
                            }
                        } else { // 최솟값 삭제
                            while (!minHeap.empty() && !visited[minHeap.getTop()[1]]) minHeap.pop();
                            if (!minHeap.empty()) {
                                visited[minHeap.getTop()[1]] = false;
                            }
                        }
                        break;
                }
            }
            while (!maxHeap.empty() && !visited[maxHeap.getTop()[1]]) maxHeap.pop();
            while (!minHeap.empty() && !visited[minHeap.getTop()[1]]) minHeap.pop();

            if (minHeap.empty() && maxHeap.empty()) sb.append("EMPTY\n");
            else sb.append(maxHeap.getTop()[0]).append(" ").append(minHeap.getTop()[0]).append("\n");
        }
        System.out.println(sb);
    }
}
