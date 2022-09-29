package BOJ;

import java.util.Scanner;

public class BOJ3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] chess = new int[] {1, 1, 2, 2, 2, 8};
        for (int i=0; i<chess.length; i++) {
            System.out.print((chess[i] - sc.nextInt()) + " ");
        }
    }
}
