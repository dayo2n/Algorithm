package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        int idx=0;
        while (len > 0) {
            if(len < 10){
                sb.append(input.substring(idx, input.length()));
                System.out.println(sb);
                return;
            }
            sb.append(input.substring(idx, idx+10)).append("\n");
            len -= 10;
            idx += 10;
        }
        System.out.println(sb);
    }
}
