package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3036 {
    static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstRing = Integer.parseInt(st.nextToken());
        for (int n = 1; n < N; n++) {
            int nextRing = Integer.parseInt(st.nextToken());
            int gcd = GCD(firstRing, nextRing);
            sb.append(firstRing / gcd).append("/").append(nextRing / gcd).append("\n");
        }
        System.out.println(sb);
    }
}
