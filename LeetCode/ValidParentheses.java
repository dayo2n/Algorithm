package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            String str = s.charAt(i) + "";

            if (str.equals("(") || str.equals("[") || str.equals("{"))
                stack.push(str);

            else if(!stack.empty()) {
                    if (stack.peek().equals("(") && str.equals(")"))
                        stack.pop();
                    else if (stack.peek().equals("[") && str.equals("]"))
                        stack.pop();
                    else if (stack.peek().equals("{") && str.equals("}"))
                        stack.pop();
                    else
                        return false;
            }else
                return false;
        }
        return stack.isEmpty();
    }
//    public boolean isValid2(String s) {
//        Stack <Character> stack = new Stack<>(); // no need to have a static stack, just declare it inside the function.
//        for (char c: s.toCharArray())
//        {
//            if(c == '(' || c == '[' || c == '{')
//                stack.push(c);
//            else if(!stack.isEmpty()) // always check if the stack is empty, for example, "]"
//            {
//                if (c == ')' && stack.pop() == '(')
//                {}
//                else if (c == ']' && stack.pop() == '[')
//                {}
//                else if (c == '}' && stack.pop() == '{')
//                {}
//                else
//                    return false;
//            }
//            else
//                return false;
//        }
//        return stack.isEmpty();
//    }
    public static void main(String[] args) {
        System.out.print(isValid("()"));
    }
}
