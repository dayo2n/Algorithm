package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) card[n] = Integer.parseInt(st.nextToken());
        Arrays.sort(card);

        int [] pick = {card[N - 1], card[N - 2], card[N -3]};
        while (pick[0] + pick[1] + pick[2] > M) {
            
        }
    }
}
