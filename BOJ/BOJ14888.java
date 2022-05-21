package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14888 {
    static char [] operator = new char[] {'+', '-', '*', '/'};
    static int [] numberOp = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            numberOp[i] = Integer.parseInt(st.nextToken());
        }

    }
}
