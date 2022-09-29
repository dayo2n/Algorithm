package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        String str = st.nextToken();

        StringBuffer sb = new StringBuffer("");

        Stack<Character> stack2 = new Stack<Character>();// 뒤집을 문자열을 담는 스택

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '<' && stack2.isEmpty()) {
                sb.append(now);
                while (true) {
                    i++;
                    now = str.charAt(i);
                    sb.append(now);
                    if (now == '>')
                        break;
                }
            } else if (now == '<' && !stack2.isEmpty()) {
                while (!stack2.isEmpty())
                    sb.append(stack2.pop());
                sb.append(now);
                while (true) {
                    i++;
                    now = str.charAt(i);
                    sb.append(now);
                    if (now == '>')
                        break;
                }
            } else if (now == ' ') {
                if (!stack2.isEmpty())
                    while (!stack2.isEmpty())
                        sb.append(stack2.pop());
                sb.append(" ");

            } else {

                stack2.push(now);
            }
        }
        if (!stack2.isEmpty())
            while (!stack2.isEmpty())
                sb.append(stack2.pop());
        System.out.println(sb);
    }
}
