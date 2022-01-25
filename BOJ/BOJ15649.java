package BOJ;
import java.io.*;
import java.util.*;

public class BOJ15649 {
    static boolean [] visited;
    static int [] answer;
    static int M, N;
    static StringBuffer sb;
    public static void backtracking(int depth){
        if (depth == M) {
            for (int value: answer){
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i + 1;
                backtracking(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        answer = new int[M];
        sb = new StringBuffer();
        backtracking(0);
        System.out.println(sb);
    }
}
