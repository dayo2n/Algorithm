package BOJ;

// Same Problem with 3067.Coin

import java.io.*;
import java.util.*;
public class BOJ9084 {
    static int [] coin, dp;
    static int N, M, T;

    public static int getDP(){
        for (int i=0; i<N; i++){ // 동전의 가지 수 N
            if(coin[i] <= M) // 구해야하는 돈이 주어진 동전의 크기보다 작은 경우 에러 발생
                dp[coin[i]] += 1;
            for (int j=coin[i]; j<=M; j++){ // 구해야하는 돈의 값 M
                dp[j] += dp[j - coin[i]];
            }
        }
        return dp[M];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine()); // 동전의 가지 수
            coin = new int[N]; // 동전 종류
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            // 작은 문제로 분할해보자! M원을 만들어야하므로 1원부터 M원까지 만들수있는 가지수를 구해보자
            dp = new int[M+1];
            sb.append(getDP()).append("\n");
        }
        System.out.println(sb);
    }
}
