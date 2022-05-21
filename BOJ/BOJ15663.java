package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15663 {
    static int [] inputArr, retArr;
    static int N, M;
    static StringBuffer sb;
    static void backtracking(int at, int depth){
        if (depth == M) {
            for (int val : retArr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=at; i<N; i++) {
            retArr[depth] = inputArr[i];
            backtracking(i + 1, depth + 1 );
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        retArr = new int[M];
        inputArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);
        backtracking(0, 0);
        System.out.println(sb);
    }
}
