package BOJ;
import java.io.*;
import java.util.*;

class Good {
    int volume;
    int cost;
    Good(int volume, int cost){
        this.volume = volume;
        this.cost = cost;
    }
}

public class BOJ12865 {
    static int [][] dp;
    static Good [] goods;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 최대 무게
        goods = new Good[N+1]; // 인덱스는 품번 (1 ~ N)
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            goods[i] = new Good(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // new Good(크기, 가치)
        }
        // 작은 문제로 분할하자
        dp = new int[N+1][K+1]; // dp 배열에는 최대 가치를 저장하고 있음
        for(int i=1; i <= N; i++){ // 품번
            for (int j=0; j <= K; j++){ // 최대 무게
                dp[i][j] = dp[i-1][j];
                if(goods[i].volume <= j)
                    dp[i][j] = Math.max(goods[i].cost + dp[i-1][j-goods[i].volume], dp[i][j]);
            }
        }
        System.out.println(dp[N][K]);
    }
}
