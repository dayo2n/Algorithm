package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11052 {
    static int [] PScard, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PScard = new int[N+1]; // 인덱스가 카드의 개수, PScard는 지불해야하는 가격
        dp = new int[N+1];

        for(int i=1; i<=N; i++){ // 인덱스가 1인 배열은 사용X
            PScard[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = PScard[1];
        for (int i=2; i<=N; i++){
            for (int j=0; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[j] + PScard[i - j]);
            }
        }
        System.out.println(dp[N]);
    }
}
