package BOJ;

import java.util.Scanner;

public class BOJ1978 {
    public static int check(int num) {
        int cnt = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        if (num == 1)
            return 0;
        if (cnt == 0)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int count = 0;

        for (int i = 0; i < num; i++) {
            int n = in.nextInt();
            count += check(n);
        }

        System.out.print(count);
    }
}