package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086 {
    static String getRelation(int a, int b){
        if (b % a == 0) return "factor";
        if (a % b == 0) return "multiple";
        return "neither";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        while (true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;
            System.out.println(getRelation(a, b));
        }
    }
}
