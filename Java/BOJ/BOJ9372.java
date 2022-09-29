package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ9372 {
    // 주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
    // 모든 정점을 지나기 위한 최소 경로의 수는 간선의 수라는 점을 이용하여 풀이
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int m=0; m<M; m++) br.readLine();
            sb.append(N-1).append("\n");
        }
        System.out.println(sb);
    }
}
