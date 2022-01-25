package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15650 {
    public static int N, M;
    public static int [] array;
    public static StringBuffer sb;
    public static void backtracking(int startIdx, int depth){
        if (depth == M) {
            for (int val : array){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=startIdx; i<=N; i++) {
            array[depth] = i;
            backtracking(i + 1, depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[M];
        sb = new StringBuffer();
        backtracking(1, 0);
        System.out.println(sb);
    }
}
