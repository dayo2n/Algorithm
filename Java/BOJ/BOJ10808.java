package BOJ;

import java.io.*;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // lower case : 97 ~ 122
        int [] alphabet = new int[122-97+1];
        String str = br.readLine();
        for (int i=0; i<str.length(); i++) {
            alphabet[str.charAt(i) - 97]++;
        }
        for (int i: alphabet)
            System.out.print(i + " ");
    }
}
