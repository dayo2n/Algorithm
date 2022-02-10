package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2981 {

    static StringBuilder sb;
    static void getDivisor(int number) {
        for (int i=2; i<=number; i++) {
            if (number % i == 0) sb.append(i).append(" ");
        }
    }
    static int LCD(int x1, int x2) {
        if (x1 %  x2 == 0) {
            return x2;
        }
        int tmp = x1;
        x1 = x2;
        x2 = tmp % x2;

        return LCD(x1, x2);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] numbers = new int[N];
        for (int n=0; n<N; n++) {
            numbers[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        int [] diff = new int[N-1];
        for (int n=0; n<N-1; n++) {
            diff[n] = numbers[n+1] - numbers[n];
        }
        for (int n=0; n<N-1-1; n++) {
            diff[n+1] = LCD(diff[n+1], diff[n]);
        }
        getDivisor(diff[N-1-1]);
        System.out.println(sb);
    }
}
