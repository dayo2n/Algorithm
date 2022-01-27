package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[3];
        for (int i=0; i<3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
