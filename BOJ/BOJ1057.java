package BOJ;

import java.io.*;
import java.util.*;

import annotation.*;
@BOJ(   number = 1057,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 20))

public class BOJ1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while(true) {
            cnt++;
            jimin = (jimin + 1) / 2;
            hansu = (hansu + 1) / 2;
            if (jimin == hansu) break;
        }
        System.out.println(cnt);
    }
}
