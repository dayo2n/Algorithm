import java.util.*;
class Solution {
    public int solution(int[] num_list, int n) {
        for (int number: num_list) {
            if (number == n) { 
                return 1;
            }
        }
        return 0;
    }
}