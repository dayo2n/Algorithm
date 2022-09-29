package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        boolean[] nums = new boolean[2001];

        st = new StringTokenizer(br.readLine(), " ");

        int counting = 0;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (nums[now + 1000] == false) {
                nums[now + 1000] = true;
                counting++;
            }
        }

        int[] toOrdered = new int[counting];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == true) {
                toOrdered[cnt] = i - 1000;
                cnt++;
            }
        }
        Arrays.sort(toOrdered);
        for (int i = 0; i < counting; i++)
            System.out.print(toOrdered[i] + " ");

    }
}
