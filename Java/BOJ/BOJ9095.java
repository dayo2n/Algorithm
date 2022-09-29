package BOJ;

import java.util.*;
import java.io.*;

public class BOJ9095 {
    public static int dp(int n){
        if(n == 1) return 1; // 1
        else if (n == 2) return 2; // 1 + 1 = 2
        else if (n == 3) return 4; // 1 + 1 + 1 = 1 + 2 = 2 + 1 = 3

        return dp(n-1) + dp(n-2) + dp(n-3);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++){
            sb.append(dp(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb);
    }
}
