package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9466 {
    static boolean [] visited, matching;
    static int[] graph;
    static StringBuilder sb;
    static int n, cnt; // 각 테스트케이스 별 학생의 수

    public static void dfs(int student) {
        visited[student] = true;
        int next = graph[student];

        if (!visited[next]) dfs(next);
        else {
            if (!matching[next]) {
                cnt++;
                while (next != student) {
                    cnt++;
                    next = graph[next];
                }
            }
        }
        matching[student] = true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테케
        sb = new StringBuilder();

        for (int tc=0; tc<T; tc++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            matching = new boolean[n + 1];
            graph = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int student = 1; student <= n; student++) {
                int choose = Integer.parseInt(st.nextToken());
                graph[student] = choose;
            }

            cnt = 0;
            for (int student = 1; student <= n; student++) {
                dfs(student);
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }
}

/*
입력
7
6
2 3 4 5 6 2
5
2 5 4 5 2
6
1 3 4 3 2 6
13
2 4 5 2 4 1 8 9 10 11 9 10 10
10
2 5 7 1 6 8 8 3 5 10
10
2 7 10 5 3 3 9 10 6 3
6
2 1 1 2 6 3

출력
1
3
2
8
6
8
4
 */
