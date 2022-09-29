package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 11659,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 27))

public class BOJ11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) numbers[n] = Integer.parseInt(st.nextToken()) + numbers[n - 1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(numbers[right] - numbers[left - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
