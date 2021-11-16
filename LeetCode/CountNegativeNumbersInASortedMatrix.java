package LeetCode;

//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

public class CountNegativeNumbersInASortedMatrix {

    public static int binarySearch(int [] row){
        int start = 0;
        int end = row.length - 1;
        int mid;

        while(start <= end){
            mid = (start  + end) / 2;
            if(row[mid] < 0) {
                System.out.println("mid " + mid);
                System.out.println("number " + (row.length - mid));
                return row.length - 1 - mid;
            }
            else if(row[mid] > 0)
                start = mid + 1;
        }
        return 0;
    }
    public static int countNegatives(int[][] grid) {
        int cnt = 0;
        // O(n * n)
//        for(int i=0; i<grid.length; i++){
//            for(int j=0; j<grid[0].length; j++){
//                if(grid[i][j] < 0)
//                    cnt ++;
//            }
//        }

        // O(n * log n)
        for(int i=0; i< grid.length; i++){
            cnt += binarySearch(grid[i]);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int [][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));

    }
}
