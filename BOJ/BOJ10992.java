package BOJ;
import java.util.Scanner;

public class BOJ10992 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i=1; i<=N; i++){
            if (i == N) {
                for (int j=0; j<2*N-1; j++) sb.append("*");
                break;
            }
            for (int j=0; j<(N-i); j++) sb.append(" ");
            sb.append("*");
            if (i!=1) {
                for (int j = 0; j < 2 * (i - 1) - 1; j++) sb.append(" ");
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
