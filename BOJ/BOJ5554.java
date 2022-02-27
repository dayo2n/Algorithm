package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5554 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dist = 0;
        for (int i = 0; i < 4; i++) dist += Integer.parseInt(br.readLine());
        int x=0, y=0;
        if (dist / 60 > 0) {
            x = dist / 60;
            dist = dist - x * 60;
        }
        y = dist;
        System.out.println(x + "\n" + y);
    }
}
