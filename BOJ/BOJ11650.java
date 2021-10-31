package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] coordinate = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            coordinate[i][0] = Integer.parseInt(st.nextToken());
            coordinate[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate, new Comparator<int[]>() {

            @Override
            public int compare(int[] x1, int[] x2) {

                if (x1[0] == x2[0])// x의 값이 같으면
                    return Integer.compare(x1[1], x2[1]);// y를 기준으로 정렬

                return Integer.compare(x1[0], x2[0]); // 나머지는 x를 기준으로 정렬

            }

        });

        for (int i = 0; i < n; i++) {
            System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
        }
    }
}
