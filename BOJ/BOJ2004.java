package BOJ;

import java.util.Scanner;

public class BOJ2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m == 0 || n == m) {
            System.out.println(0);
            return;
        }
        long FIVE = 5;
        int cntFive = 0;
        while (n >= FIVE) {
            cntFive += (n / FIVE);
            FIVE *= 5;
        }
        long TWO = 2;
        int cntTwo = 0;
        while (n >= TWO) {
            cntTwo += (n / TWO);
            TWO *= 2;
        }

        TWO = 2;
        FIVE = 5;
        while (m >= FIVE) {
            cntFive -= (m / FIVE);
            FIVE *= 5;
        }
        while (m >= TWO) {
            cntTwo -= (m / TWO);
            TWO *= 2;
        }

        TWO = 2;
        FIVE = 5;
        while ((n-m) >= FIVE) {
            cntFive -= ((n-m) / FIVE);
            FIVE *= 5;
        }
        while (n-m >= TWO) {
            cntTwo -= ((n-m) / TWO);
            TWO *= 2;
        }
        System.out.println(Math.min(cntFive, cntTwo));
    }
}
