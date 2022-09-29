package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11722 {

    static int N;
    static int [] LDS, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LDS = new int[N];
        Arrays.fill(LDS, 1);

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j] > arr[i]){
                    if (LDS[j] >= LDS[i]) LDS[i] = LDS[j] + 1;
                }
            }
        }

        Arrays.sort(LDS);
        System.out.println(LDS[N-1]);
    }
}
