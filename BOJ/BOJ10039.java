package BOJ;

import java.io.*;

public class BOJ10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i=0; i<5; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp < 40) tmp = 40;
            sum += tmp;
        }
        System.out.println(sum / 5);
    }
}
