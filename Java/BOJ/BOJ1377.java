package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1377 {

    static int [] A;
    static void swap(int idx1, int idx2) {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];

        for (int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        boolean changed;
        for (int i=1; i<=N+1; i++) {
            changed = false;
            for (int j=1; j<=N-i; j++) {
                if (A[j] > A[j+1]) {
                    changed = true;
                    swap(j, j+1);
                }
            }
            if (changed == false) {
                sb.append(i).append("\n");
                break;
            }
        }
        System.out.println(sb);
    }
}
