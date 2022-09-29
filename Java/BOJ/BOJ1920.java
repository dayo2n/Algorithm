package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1920 {

    public static int binarySearch(int [] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(end >= start){
//            System.out.println("mid "+mid);
            mid = (end + start) / 2;
            if(arr[mid] == target)
                return 1;
            else if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid -1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        int [] target = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++){
//            System.out.println((Arrays.binarySearch(a, target[i])) >= 0 ? 1 : 0);
//            System.out.println(binarySearch(a, target[i]) == true ? 1 : 0);
        }
    }
}