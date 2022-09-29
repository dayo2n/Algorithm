package BOJ;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ1271 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());
        System.out.println(N.divide(M));
        System.out.println(N.mod(M));
    }
}
