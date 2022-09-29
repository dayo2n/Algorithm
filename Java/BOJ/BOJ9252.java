package BOJ;

import java.io.*;
public class BOJ9252 {

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
        StringBuilder sb = new StringBuilder();
        int a = str1.length(), b = str2.length();
        while (a>0 && b>0) {
            if (LCS[a][b] == LCS[a-1][b]) a--;
            else if (LCS[a][b] == LCS[a][b-1]) b--;
            else {
                sb.append(str1.charAt(--a));
                b--;
            }
        }
        System.out.println(sb.reverse());
    }
}