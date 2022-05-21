package BOJ;
import java.io.*;
import java.util.*;

public class BOJ13022 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = 0;
        char [] wolf = {'w', 'o', 'l', 'f'};
        int [] cntOLF = new int[4];
        int idx = 0;
        for (int i=0; i<input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == wolf[idx]) {
                cntOLF[idx]++;
                continue;
            }
            else {
//                if ()
                idx++;
                if (cnt > 0) {

                } else {// w가 아닌 다른 문자가 먼저 온 경우이므로
                    System.out.println(0);
                    return;
                }
            }
        }
    }
}
