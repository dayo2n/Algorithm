package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16507 {
    static int [][] pixel;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        pixel = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                pixel[r][c] = Integer.parseInt(st.nextToken());
                if (r > 0) pixel[r][c] += pixel[r - 1][c];
                if (c > 0) pixel[r][c] += pixel[r][c - 1];
                if (r > 0 && c > 0) pixel[r][c] -= pixel[r - 1][c - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int r1, c1, r2, c2, retPixel;
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken()) - 1;
            c1 = Integer.parseInt(st.nextToken()) - 1;
            r2 = Integer.parseInt(st.nextToken()) - 1;
            c2 = Integer.parseInt(st.nextToken()) - 1;
            if (r2 == 0 || c2 == 0) retPixel = pixel[r2][c2] - pixel[r1][c1];
            else if (r1 == 0 && c1 == 0) retPixel = pixel[r2][c2];
            else if (r1 == 0) {
                if (c1 == c2) {
                    retPixel = pixel[r2][c2] - pixel[r2][c2 - 1];
                } else retPixel = pixel[r2][c2] - pixel[r2][c2 - c1 - 1];
            }
            else if (c1 == 0) {
                if (r1 == r2) {
                    retPixel = pixel[r2][c2] - pixel[r2 - 1][c1];
                } else retPixel = pixel[r2][c2] - pixel[r2 - r1 - 1][c1];
            }
            else retPixel = pixel[r2][c2] - pixel[r1 - 1][c2] - pixel[r2][c1 - 1] + pixel[r1 - 1][c1 - 1];
            retPixel /= ((r2 - r1 + 1) * (c2 - c1 + 1));
            sb.append(retPixel).append("\n");
        }
        System.out.println(sb);
    }
}

/*
4 3 1
25 93 64
10 29 85
80 63 71
99 58 86
2 2 2 3
 */