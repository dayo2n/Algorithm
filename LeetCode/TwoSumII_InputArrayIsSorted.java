package LeetCode;

public class TwoSumII_InputArrayIsSorted {

    // binary search : O(n * log n)
//    public static int binarySearch(int start, int [] arr, int target){
//        int end = arr.length - 1;
//        int mid;
//
//        while(end >= start){
//            mid = (end + start) / 2;
//            if(arr[mid] == target)
//                return mid;
//            if(arr[mid] > target)
//                end = mid - 1;
//            else if(arr[mid] < target)
//                start = mid + 1;
//        }
//        return -1;
//    }
//
//    public int[] twoSum(int[] numbers, int target) {
//        for(int i=0; i<numbers.length; i++){
//            int tmpTarget = target - numbers[i];
//            int targetIdx = binarySearch(i+1, numbers, tmpTarget);
//            if(targetIdx != -1){
//                return new int[]{i + 1, targetIdx + 1};
//            }
//        }
//        return new int[]{};
//    }

    // O(n) : 작은 쪽에서 올라가고 큰 쪽에선 내려오는 방식
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum;

        while(left < right){
            sum = numbers[left] + numbers[right];
            if(sum == target)
                break;

            if(sum > target)  // 크면 오른쪽을 줄여
                right --;
            else // 작으면 왼쪽을 올려
                left ++;
        }
        return new int[]{left + 1, right + 1};
    }
}
