package BOJ;
import java.io.*;
import java.util.*;

public class BOJ9184 {

    static int [][][] dp;
    static int w(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (dp[a][b][c] != 0) return dp[a][b][c];
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b, c;
        dp = new int[51][51][51];
        StringBuffer sb = new StringBuffer();
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 &&  b == -1 && c == -1) break;
            sb.append("w(" + a + ", " + b + ", " + c + ") = ");
            sb.append(w(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }
}