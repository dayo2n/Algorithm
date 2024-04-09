// ArrayList를 활용하여 가독성, 효율 향상
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList();
        for (Integer number: arr) {
            list.add(number);
        }
        for (Integer delete: delete_list) {
            list.remove((Integer)delete);
        }
        
        int[] answer = new int[list.size()];
        for (int index = 0; index < answer.length; index++) {
            answer[index] = list.get(index);
        }
        return answer;
    }
}

/*
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        boolean [] willBeDelete = new boolean[arr.length];
        for (int deleteIndex = 0; deleteIndex < delete_list.length; deleteIndex++) {
            int target = delete_list[deleteIndex];
            for (int arrIndex = 0; arrIndex < arr.length; arrIndex++) {
                if (willBeDelete[arrIndex]) { continue; }
                if (arr[arrIndex] == target) {
                    willBeDelete[arrIndex] = true;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (!willBeDelete[index]) {
                list.add(arr[index]);
            }
        }
        int[] answer = new int[list.size()];
        for(int index = 0; index < answer.length; index++) {
            answer[index] = list.get(index);
        }
        return answer;
    }
}
*/