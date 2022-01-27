package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9093 {
    static String reverseStr(String str){
        String ret = "";
        for (int i=str.length()-1; i>=0; i--){
            ret += str.charAt(i);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb.append(reverseStr(st.nextToken())).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
