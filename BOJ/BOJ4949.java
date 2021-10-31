package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<Character>();

        boolean smallOpen = false;
        boolean bigOpen = false;

        int cnt = 1;

        StringBuffer sb = new StringBuffer();

        while (true) {

            stack.clear();
            String str = br.readLine();

            if (str.length() == 1 && str.equals("."))
                break;

            for (int i = 0; i < str.length(); i++) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(')
                        smallOpen = true;
                    if (stack.peek() == '[')
                        bigOpen = true;
                }
                if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || !smallOpen) {
                        sb.append("no\n");
                        break;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        sb.append("no\n");
                        smallOpen = false;
                        bigOpen = false;
                        break;
                    }
                } else if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || !bigOpen) {
                        sb.append("no\n");
                        break;
                    } else if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        sb.append("no\n");
                        smallOpen = false;
                        bigOpen = false;
                        break;
                    }
                } else if (str.charAt(i) == '(') {
                    if (stack.isEmpty() || stack.peek() == '(' || stack.peek() == '[') {
                        stack.push('(');
                    }
                } else if (str.charAt(i) == '[') {
                    if (stack.isEmpty() || stack.peek() == '(' || stack.peek() == '[') {
                        stack.push('[');
                    }
                }
                if (i == str.length() - 1) {
                    if (stack.isEmpty())
                        sb.append("yes\n");
                    else
                        sb.append("no\n");
                }

                smallOpen = false;
                bigOpen = false;
            }
            cnt++;

        }
        System.out.println(sb);
    }
}