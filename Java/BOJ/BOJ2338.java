package BOJ;

import java.math.BigInteger;
import java.util.*;

public class BOJ2338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());
        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
    }
}
