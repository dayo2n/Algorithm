package BOJ;

import java.util.*;

public class BOJ1924 {

    final static String [] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    final static int [] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();

        int totalDay = 0;

        for(int i=0; i<month-1; i++){
            totalDay += daysInMonth[i];
        }
        totalDay += day;

        System.out.println(week[totalDay % 7]);
    }
}
