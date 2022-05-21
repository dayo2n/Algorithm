package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 3273,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 24))

public class BOJ3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) numbers[n] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int cnt = 0;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == x) {
                cnt++;
                left++;
                right--;
            }
            else if (numbers[left] + numbers[right] > x) {
                right--;
            } else left++;
        }
        System.out.println(cnt);
    }
}
