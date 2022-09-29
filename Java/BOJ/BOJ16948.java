package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16948 {
    static int N, r1, c1, r2, c2;
    static int [][] chessBoard;
    static Queue<int []> queue;
    static int [] moveRow = {-2, -2, 0, 0, 2, 2}, moveColumn = {-1, 1, -2, 2, -1, 1};

    static void bfs() {
        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.poll();

            for (int move = 0; move < 6; move++) {
                int nr = row + moveRow[move];
                int nc = col + moveColumn[move];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (chessBoard[nr][nc] == 0) {
                    chessBoard[nr][nc] = chessBoard[row][col] + 1;
                    queue.add(new int[] {nr, nc});
                }
                if (nr == r2 && nc == c2) {
                    if (chessBoard[r2][c2] == -1) chessBoard[nr][nc] = chessBoard[row][col] + 1;
                    else chessBoard[r2][c2] = Math.min(chessBoard[r2][c2], chessBoard[row][col] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        chessBoard = new int[N][N];
        queue = new LinkedList<>();
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        chessBoard[r2][c2] = -1;
        queue.add(new int[] {r1, c1});
        bfs();
        System.out.println(chessBoard[r2][c2]);
    }
}
