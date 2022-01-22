package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11053 {

    static int N;
    static int [] LIS, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LIS = new int[N];
        Arrays.fill(LIS, 1);

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if (LIS[j] >= LIS[i]) LIS[i] = LIS[j] + 1;
                }
            }
        }

        Arrays.sort(LIS);
        System.out.println(LIS[N-1]);
    }
}
