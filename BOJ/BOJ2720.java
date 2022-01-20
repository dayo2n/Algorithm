package BOJ;
import java.util.*;

public class BOJ2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] money = {25, 10, 5, 1};
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<T; i++){
            int C = sc.nextInt();
            for(int j=0; j<money.length; j++){
                sb.append(C / money[j]).append(" ");
                C -= (C / money[j]) * money[j];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
