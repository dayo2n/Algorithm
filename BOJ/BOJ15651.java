package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15651 {
    static boolean [] visited;
    static int [] arr;
    static int N, M;
    static StringBuffer sb;
    static void backtracking(int depth){
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            arr[depth] = i + 1;
            backtracking(depth + 1 );
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];
        backtracking(0);
        System.out.println(sb);
    }
}
