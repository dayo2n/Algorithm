import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int length = numbers.length;
        Arrays.sort(numbers);
        int results = numbers[length-1] * numbers[length-2];
        if (numbers[0] < 0 && numbers[1] < 0) {
            results = Math.max(results, numbers[0] * numbers[1]);
        }
        return results;
    }
}