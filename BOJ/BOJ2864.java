package BOJ;

import java.util.Scanner;

public class BOJ2864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        System.out.println((Integer.parseInt(A.replace("6", "5")) + Integer.parseInt(B.replace("6", "5"))) + " " + (Integer.parseInt(A.replace("5", "6")) + Integer.parseInt(B.replace("5", "6"))));
    }
}
