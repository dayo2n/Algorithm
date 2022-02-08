package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int [] len;
        while (true) {
            len = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i=0 ;i<3; i++) len[i] = Integer.parseInt(st.nextToken());
            if (len[0] == 0 && len[1] == 0 && len[2] == 0) break;
            Arrays.sort(len);

            // 오름차순으로 입력된다고 가정
            if (len[0] * len[0] + len[1] * len[1] == len[2] * len[2]) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.println(sb);
    }
}
