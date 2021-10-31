package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ4378 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // StringTokenizer st;
        String[] keyboard = { "`1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;\'", "ZXCVBNM,./" };

        while (sc.hasNextLine()) {
            // st = new StringTokenizer(br.readLine());
            String st = sc.nextLine();
            // System.out.println(st);
            String s = "";
            char tmp;

            for (int i = 0; i < st.toString().length(); i++) {
                tmp = st.toString().charAt(i);
                // System.out.println(i + " : " + tmp);
                if (tmp == ' ')
                    s += " ";
                else {
                    for (int j = 0; j < keyboard.length; j++) {
                        if (keyboard[j].contains(tmp + "")) {
                            int index = keyboard[j].toString().indexOf(tmp + "");
                            s += keyboard[j].toString().charAt(index - 1);
                            // System.out.println(s);
                        }
                    }
                }
            }
            sb.append(s + "\n");
        }
        System.out.println(sb);

    }
}
