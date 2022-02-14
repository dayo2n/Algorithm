package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int curHour = Integer.parseInt(st.nextToken());
        int curMin = Integer.parseInt(st.nextToken());
        int needMin = Integer.parseInt(br.readLine());

        int endHour = curHour;
        int endMin = curMin + needMin;
        if (endMin < 60) System.out.println(curHour + " " + endMin);
        else {
            if (needMin % 60 == 0) {
                endHour += (endMin / 60);
                if (endHour < 24) System.out.println(endHour + " " + curMin);
                else System.out.println((endHour - 24) + " " + curMin);
            } else {
                endHour += (endMin / 60);
                endMin -= (endMin / 60 * 60);
                if (endHour < 24) System.out.println(endHour + " " + endMin);
                else System.out.println((endHour - 24) + " " + endMin);
            }
        }
    }
}
