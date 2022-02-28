package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import annotation.*;
@BOJ(   number = 9996,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 28 ))

public class BOJ9996 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String [] inputPattern = br.readLine().split("\\*");
        String pattern = "^" + inputPattern[0] + "[a-z]*" + inputPattern[1] + "$";
        System.out.println(pattern);

        for (int n = 0; n < N; n++) {
            if (Pattern.matches(pattern, br.readLine())) sb.append("DA\n");
            else sb.append("NE\n");
        }
        System.out.println(sb);
    }
}
