package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24913 {

    static int N;
    static int [] poll;

    static void addPoll(int x, int p) {
        poll[p] += x;
    }

    static String askPossibility (int x, int y) {
        int countNot = 0;
        for (int n = 0; n < N; n++) {
            if (poll[n] + y > poll[N] + x) countNot++;
        }
        return (countNot == N ? "NO\n" : "YES\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        poll = new int[N + 1];
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) addPoll(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1);
            else sb.append(askPossibility(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        System.out.println(sb);
    }
}
