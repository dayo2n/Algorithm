import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() != arr[i])
                    stack.push(arr[i]);
            } else stack.push(arr[i]);
        }
        int stackSize = stack.size();
        int [] answer = new int[stackSize];
        for (int i = stackSize - 1; i >= 0; i--)
            answer[i] = stack.pop();
        return answer;
    }
}