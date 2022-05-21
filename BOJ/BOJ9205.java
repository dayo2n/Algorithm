package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9205 {
    static class Position {
        int x, y;
        Position (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n;
        Position sanggeun, festival;
        Position [] store;
        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            store = new Position[n];
            st = new StringTokenizer(br.readLine());
            sanggeun = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int N = 0; N < n; N++) {
                st = new StringTokenizer(br.readLine());
                store[N] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            festival = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));


        }
    }
}
