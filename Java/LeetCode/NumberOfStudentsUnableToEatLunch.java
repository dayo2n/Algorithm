package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Problem Number 1700
public class NumberOfStudentsUnableToEatLunch {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<>();
        Stack<Integer> sandwich = new Stack<>();

        for(int i=0; i< students.length; i++){
            student.add(students[i]);
            sandwich.add(sandwiches[sandwiches.length-i-1]);
        }

        int flag = 0;
        while(!student.isEmpty()){

            // 한바퀴 검사 후 결국 매칭되지않으면
            /*
            *
             */
            if(flag == student.size())
                break;

            if(student.peek() == sandwich.peek()){
                student.poll();
                sandwich.pop();
                flag = 0;
            }else{
                student.add(student.poll());
                flag++;
            }
        }

        return student.size(); // default return
    }

//    public static void main(String[] args) {
//        int [] students = {1,1,0,0};
//        int [] sandwiches = {0,1,0,1};
//        System.out.println(countStudents(students, sandwiches));
//    }
}
