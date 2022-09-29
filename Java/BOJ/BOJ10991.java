package BOJ;

import java.util.Scanner;

public class BOJ10991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i=1; i<=N; i++){
            for (int j=0; j<(N-i); j++) sb.append(" ");
            for (int j=0; j<i; j++) sb.append("* ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
