package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ23881 {

    static void swap(int [] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[Integer.parseInt(st.nextToken())];
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int a = 0; a < arr.length; a++) arr[a] = Integer.parseInt(st.nextToken());

        // selection sort
        int N = arr.length - 1, cnt = 0;
        while (N > 1) {
            int max = N;
            for (int a = 0; a < N; a++) if (arr[max] < arr[a]) max = a;
            if (arr[max] != arr[N]) {
                swap(arr, max, N);
                cnt++;
                if (cnt == K) {
                    System.out.println(arr[max] + " " + arr[N]);
                    return;
                }
            }
            N--;
        }
        System.out.println(-1);
    }
}

