package BOJ;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ24309 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // x * a = b - c
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger c = new BigInteger(sc.next());
        System.out.println((b.subtract(c)).divide(a));
    }
}
