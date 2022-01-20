package BOJ;

import java.util.Scanner;

public class BOJ5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();

        int [] money = {500, 100, 50, 10, 5, 1};
        int cntChange = 0, idx = 0, quotient = 0;
        while(n > 0){
            quotient = n / money[idx];
            cntChange += quotient;
            n -= (quotient * money[idx]);
            idx++;
        }
        System.out.println(cntChange);
    }
}
