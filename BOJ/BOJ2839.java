package BOJ;

import java.util.Scanner;

public class BOJ2839 {
    static int [] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배달해야하는 설탕 무게
        dp = new int[N+1];
        if (N >= 3){
            dp[3] = 1;
            if (N >= 5) dp[5] = 1;
        }
        for(int i=6; i<=N; i++){
            if(dp[i-3] > 0) dp[i] = dp[i-3] + 1;
            if(dp[i-5] > 0)
                if (dp[i] > 0)
                    dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
                else dp[i] = dp[i-5] + 1;
        }
        System.out.println((dp[N] == 0 ? -1 : dp[N]));
    }
}
