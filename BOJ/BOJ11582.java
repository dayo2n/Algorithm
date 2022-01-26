package BOJ;

import java.util.*;
import java.io.*;

public class BOJ11582 {
    static int N, member;
    static int [] taste;
    static StringBuffer sb;
    public static void solve(){
        int [][] tmp = new int[member][taste.length / member];
        for (int i=0; i<member; i++){
            for (int j=0; j<taste.length/member; j++){
                tmp[i][j] = taste[(taste.length / member) * i + j];
            }
            Arrays.sort(tmp[i]);
            for (int j=0; j<taste.length/member; j++) {
                sb.append(tmp[i][j]).append(" ");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        taste = new int[N];
        for (int i=0; i<N; i++) {
            taste[i] = Integer.parseInt(st.nextToken());
        }
        member = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        solve();
        System.out.println(sb);
    }
}
