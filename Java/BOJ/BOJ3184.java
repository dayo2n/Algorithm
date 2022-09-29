package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3184 {
    static int R, C;
    static int [][] fence;
    static int [][] convertedBoard; // 영역을 번호로 저장하기 위한 보드
    static char [][] board;
    static boolean [][] visited;
    static int survivedSheep, survivedWolf;
    static final char SHEEP = 'o';
    static final char WOLF = 'v';
    static final char VACANT = '.';
    static final char FENCE = '#';

    static void dfs(int row, int col, int cnt) {
        visited[row][col] = true;
        convertedBoard[row][col] = cnt;
        int [] upDown = {1, -1, 0, 0};
        int [] leftRight = {0, 0, -1, 1};
        for (int i=0; i<4; i++) {
            int newRow = row + upDown[i];
            int newCol = col + leftRight[i];
            if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C) {
                if (!visited[newRow][newCol] && board[newRow][newCol] != FENCE)
                    dfs(newRow, newCol, cnt);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        convertedBoard = new int[R][C];
        visited = new boolean[R][C];

        for (int i=0; i<R; i++) {
            String input = br.readLine();
            for (int j=0; j<C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == SHEEP) survivedSheep++;
                else if (board[i][j] == WOLF) survivedWolf++;
            }
        }

        int cnt = 0;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (!visited[row][col]) {
                    if (board[row][col] == WOLF || board[row][col] == SHEEP) {
                        dfs(row, col, ++cnt);
                    }
                }
            }
        }
        fence = new int[cnt][2]; //[][0]: WOLF, [][1]: SHEEP

        for (int row=0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (convertedBoard[row][col] != 0) {
                    if (board[row][col] == SHEEP)
                        fence[convertedBoard[row][col] - 1][1]++;
                    else if (board[row][col] == WOLF)
                        fence[convertedBoard[row][col] - 1][0]++;
                }
            }
        }

        // 각 영역의 양과 늑대의 수를 계산해주자
        for (int i = 0; i<cnt; i++) {
            if (fence[i][0] >= fence[i][1]) survivedSheep -= fence[i][1];
            else survivedWolf -= fence[i][0];
        }

        System.out.println(survivedSheep + " " + survivedWolf);
    }
}
