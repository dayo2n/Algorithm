package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor = N % H;
            int room = N / H + 1;
            if (floor == 0) {
                floor = H;
                if (room - 1 < 10) sb.append(floor).append("0").append(room - 1).append("\n");
                else sb.append(floor).append(room - 1).append("\n");
            } else {
                if (room < 10) sb.append(floor).append("0").append(room).append("\n");
                else sb.append(floor).append(room).append("\n");
            }
        }
        System.out.println(sb);
    }
}
