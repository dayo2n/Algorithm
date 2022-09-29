package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import annotation.*;
//@BOJ(   number = ,
//        tier = BaekjoonTier,
//        solveDate = @SolveDate(year = 2022, month = 3 ,day = ))
public class BOJ13706 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        if (N.equals(1)) {
            System.out.println(1);
            return;
        }
        BigInteger numberOne = new BigInteger("1");
        BigInteger left = new BigInteger("0"), right = N;
        BigInteger mid = null;

        while (left.compareTo(right) == -1) {
            mid = new BigInteger(left.add(right).divide(new BigInteger("2")).toString());
            BigInteger root = mid.multiply(mid);

            if (root.compareTo(N) == 0) break;
            else if (root.compareTo(N) == 1) right = mid.subtract(numberOne);
            else left = mid.add(numberOne);
        }
        System.out.println(mid);
    }
}
