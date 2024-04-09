class Solution {
    public int[] solution(int[] arr, int k) {
        boolean isEven = k % 2 == 0;
        for(int index = 0; index < arr.length; index ++) {
            if (isEven) {
                arr[index] += k;
            } else {
                arr[index] *= k;
            }
        }
        return arr;
    }
}