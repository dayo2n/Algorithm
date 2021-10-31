package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class HW {
    int score;
    int time;

    public HW(int s, int t) {
        this.score = s;
        this.time = t;
    }
}

public class BOJ17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<HW> hw = new Stack<HW>();

        int total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int bool = Integer.parseInt(st.nextToken());
            if (bool == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                hw.push(new HW(score, time - 1));
                if (hw.peek().time == 0)
                    total += hw.pop().score;
            } else {// bool == 0
                if (!hw.isEmpty()) {
                    hw.peek().time--;
                    if (hw.peek().time == 0)
                        total += hw.pop().score;
                }
            }
        }
        System.out.println(total);
    }
}
