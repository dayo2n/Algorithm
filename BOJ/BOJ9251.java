package BOJ;

import java.util.*;
import java.io.*;

public class BOJ9251 {

    static int [][] LCS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        LCS = new int[str1.length()+1][str2.length()+1];


        for (int i=1; i<str1.length()+1; i++){
            for (int j=1; j<str2.length()+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else if (str1.charAt(i-1) != str2.charAt(j-1)) {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        System.out.println(LCS[str1.length()][str2.length()]);
    }
}
