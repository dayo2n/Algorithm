package BOJ;
import java.util.*;
public class BOJ11051 {

    static int [][] dp;

    static int bino(int n, int k){
        if(dp[n][k] > 0) return dp[n][k];
        if(n == k || k == 0) return dp[n][k] = 1;
        return dp[n][k] = (bino(n-1, k-1) + bino(n-1, k)) % 10_007; // 모듈러 연산을 동적계획법에서 적용
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        dp = new int[N+1][K+1];
        System.out.println(bino(N, K));
    }
}
