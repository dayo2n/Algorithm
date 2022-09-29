package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 가지 수
        int k = Integer.parseInt(st.nextToken()); // 만들어야할 가치의 크기
        int [] coin = new int[n];
        int [] dp = new int[k+1];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=k; j++){
                dp[j] += dp[j - coin[i]];
            }
            for (int j=0; j<=k; j++) {
            }
        }
        System.out.println(dp[k]);
    }
}
