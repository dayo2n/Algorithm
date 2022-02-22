package BOJ;

import java.io.*;
import java.util.*;

import annotation.*;
@BOJ(   number = 10799,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 23))

public class BOJ10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split("");
        Stack<Integer> openBracket = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                openBracket.push(i);
            } else {
                int target = openBracket.pop();
                if (i - target == 1) cnt += openBracket.size();
                else cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
