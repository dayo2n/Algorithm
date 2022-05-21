package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A == B && B == C) { // 다 같은 경우
            System.out.println(10000 + A * 1000);
        }
        else if (A != B && A != C && B != C) { // 다 다른 경우
            System.out.println(Math.max(A, Math.max(B, C)) * 100);
        }
        else { // 두 개만 같은 경우
            if (A == B || A == C)
                System.out.println(1000 + A * 100);
            else if (B == C)
                System.out.println(1000 + B * 100);
        }
    }
}
