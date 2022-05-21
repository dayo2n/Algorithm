package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int MAX_IDX = (int) Math.pow(10, number);

        int [] ascend = new int[MAX_IDX];

        ascend[0] = 1;
        for (int n = 1; n < MAX_IDX; n++) {
            String N = n + "";
            if (N.length() == 1) ascend[n] = ascend[n - 1] + 1;

            for (int i = 0; i < N.length() - 1; i++) {
                if (N.charAt(i) > N.charAt(i + 1)) {
                    ascend[n] = ascend[n - 1];
                    break;
                }
                if (i == N.length() - 1 - 1) ascend[n] = ascend[n - 1] + 1;
            }

        }
        System.out.println(ascend[MAX_IDX - 1]);
    }
}
