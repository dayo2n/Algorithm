package BOJ;

import java.io.*;
public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i=1; i<=N; i++){
            int tmp = i;
            while (tmp != 0) {
                if (tmp % 5 == 0) cnt++;
                else break;
                tmp /= 5;
            }
        }
        System.out.println(cnt);
    }
}
