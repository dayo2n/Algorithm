package BOJ;

import annotation.BOJ;
import annotation.BaekjoonTier;
import annotation.SolveDate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@BOJ(   number = 9375,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 11))

public class BOJ9375 {
    static Map<String, Integer> fashion;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < TC; test_case++) {
            fashion = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int n = 0; n < N; n++) {
                String [] input = br.readLine().split(" ");
                if(fashion.containsKey(input[1])) fashion.put(input[1], fashion.get(input[1]) + 1);
                else fashion.put(input[1],1);
            }
            int numberOfCase = 1;
            for (String key : fashion.keySet()) numberOfCase *= (fashion.get(key) + 1);
            System.out.println(numberOfCase-1);
        }
    }
}
