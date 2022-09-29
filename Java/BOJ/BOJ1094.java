package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int sum = 0;
        Stack<Integer> sticks = new Stack<Integer>();
        Stack<Integer> tmpStack = new Stack<Integer>();

        sticks.push(64);

        if (x == 64) {
            System.out.println("1");
            return;
        }

        while (sum != x) {

            int tmp = sticks.pop() / 2;

            sticks.push(tmp);

            while (!sticks.isEmpty()) {
                tmpStack.push(sticks.peek());
                sum += sticks.pop();
            }

            if (sum > x) {
                while (!tmpStack.isEmpty())
                    sticks.push(tmpStack.pop());
            } else if (sum < x) {
                while (!tmpStack.isEmpty())
                    sticks.push(tmpStack.pop());
                sticks.push(tmp);
            } else {// (sum == x)
                System.out.println(tmpStack.size());
                break;
            }

            sum = 0;
        }
    }
}
