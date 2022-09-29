package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2751 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            num[tmp + 1000000] = true;

        }
        // Arrays.sort(num);
        //
        // StringBuffer sb = new StringBuffer();
        // for (int i = 0; i < n; i++) {
        // sb.append(num[i] + "\n");
        // }
        // System.out.println(sb);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num.length; i++)
            if (num[i])
                sb.append((i - 1000000) + "\n");
        System.out.println(sb);

    }
}