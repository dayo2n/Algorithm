package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ2749 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s = input.next();
        String devide = "1500000";
        BigInteger devidor = new BigInteger(devide);

        BigInteger n = new BigInteger(s);
        BigInteger order = n.remainder(devidor);
        long[] arr = new long[1500000];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < 1500000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
        }

        BigInteger i = BigInteger.ZERO;

        int k = 0;
        while (!order.equals(i)) {
            i = i.add(BigInteger.ONE);
            k++;
        }
        System.out.println(arr[k]);

    }

    public static int cut(int k) {
        return k % 1000000;
    }

}