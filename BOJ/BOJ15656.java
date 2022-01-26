package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15656 {
    static int [] inputArr, retArr;
    static int N, M;
    static StringBuffer sb;
    static void backtracking(int depth){
        if (depth == M) {
            for (int val : retArr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            retArr[depth] = inputArr[i];
            backtracking(depth + 1 );

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputArr = new int[N];
        retArr = new int[M];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
            if (max < inputArr[i]) max = inputArr[i];
        }
        Arrays.sort(inputArr);
        backtracking(0);
        System.out.println(sb);
    }
}
