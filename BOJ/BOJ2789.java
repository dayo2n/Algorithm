package BOJ;

import java.io.*;

public class BOJ2789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int len = 0; len < before.length(); len++) {
            String check = String.valueOf(before.charAt(len));
            if (!"CAMBRIDGE".contains(check)) sb.append(before.charAt(len));
        }
        System.out.println(sb);
    }
}
