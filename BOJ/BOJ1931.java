package BOJ;

import annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@BOJ(   number = 1931,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 16))

public class BOJ1931 {

    static class Meeting implements Comparable<Meeting> {
        int start, end;
        Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return this.start - o.start;
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Meeting [] meetings = new Meeting[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            meetings[n] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
        int cnt = 1;
        int next = meetings[0].end;
        for (int n = 1; n < N; n++) {
            if (meetings[n].start >= next) {
                cnt++;
                next = meetings[n].end;
            }
        }
        System.out.println(cnt);
    }
}
