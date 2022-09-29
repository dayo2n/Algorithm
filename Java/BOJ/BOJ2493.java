package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int input;
        int peek;
        int j;

        // String ans = "";
        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            j = i;
            while (!stack.empty()) {
                peek = stack.peek();
                j--;
                if (peek > input) {
                    sb.append((j + 1) + " ");
                    break;
                } else
                    stack.pop();
            }
            if (stack.empty())
                sb.append("0 ");
            stack.push(input);
        }
        System.out.println(sb);
    }
}