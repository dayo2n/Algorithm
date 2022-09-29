package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
@BOJ(   number = 7562,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 13))
public class BOJ7562 {
    static int I;
    static int [][] chessBoard;
    static boolean [][] visited;
    static StringBuilder sb;
    static int [] moveRow = {-2, -1, 1, 2, 2, 1, -1, -2}, moveColumn = {1, 2, 2, 1, -1, -2, -2, -1};

    static void bfs(int row, int col, int targetRow, int targetCol) {
        Queue <int []> queue = new LinkedList<>();
        queue.clear();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            if (x == targetRow && y == targetCol) break;

            for (int i = 0; i < 8; i++) {
                int nx = x + moveRow[i];
                int ny = y + moveColumn[i];
                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                if (!visited[nx][ny]) {
                    chessBoard[nx][ny] = chessBoard[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            queue.poll();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
            // 체스판 한 변의 길이
            I = Integer.parseInt(br.readLine());
            chessBoard = new int[I][I];
            visited = new boolean[I][I];

            // 현재 나이트의 위치
            st = new StringTokenizer(br.readLine());
            int curKnightRow = Integer.parseInt(st.nextToken());
            int curKnightCol = Integer.parseInt(st.nextToken());

            // 나이트가 이동하려는 칸
            st = new StringTokenizer(br.readLine());
            int moveKnightRow = Integer.parseInt(st.nextToken());
            int moveKnightCol = Integer.parseInt(st.nextToken());

            if (curKnightRow != moveKnightRow || curKnightCol != moveKnightCol) bfs(curKnightRow, curKnightCol, moveKnightRow, moveKnightCol);

            sb.append(chessBoard[moveKnightRow][moveKnightCol]).append("\n");
        }
        System.out.println(sb);
    }
}
