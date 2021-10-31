package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextInt() + "";
        String[] num = n.split("");
        Integer[] number = new Integer[num.length];
        for (int i = 0; i < num.length; i++)
            number[i] = Integer.parseInt(num[i]);

        Arrays.sort(number, Collections.reverseOrder());

        for (int i = 0; i < number.length; i++)
            System.out.print(number[i]);

    }
}
