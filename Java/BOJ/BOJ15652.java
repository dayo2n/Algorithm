package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static boolean [] visited;
    static int [] arr;
    static int N, M;
    static StringBuffer sb;
    static void backtracking(int at, int depth){
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=at; i<N; i++) {
            arr[depth] = i + 1;
            backtracking(i, depth + 1 );
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
        backtracking(0, 0);
        System.out.println(sb);
    }
}
