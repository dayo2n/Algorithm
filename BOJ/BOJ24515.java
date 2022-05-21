package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ24515 {

    static ArrayList<Character>[] graph;
    static char [][] area;
    static boolean [][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        visited = new boolean[N][N];
        graph = new ArrayList[26];

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < N; col++) {
                char cur = line.charAt(col);
                area[row][col] = cur;
                if (cur == '.') continue;
                if (row != 0) {
                    graph[cur - 'A'].add(area[row - 1][col]);
                    graph[area[row - 1][col] - 'A'].add(cur);
                }
                if (col != 0) {
                    graph[cur - 'A'].add(area[row][col - 1]);
                    graph[area[row][col - 1] - 'A'].add(cur);
                }
            }
        }
    }
}
