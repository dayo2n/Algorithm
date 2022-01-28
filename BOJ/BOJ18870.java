package BOJ;

import java.io.*;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] input = new int [N];
        for (int i=0; i<N; i++) {
            input[i] =Integer.parseInt(st.nextToken());
        }

        int [] sorted = input.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i: sorted) {
            if (!map.containsKey(i))
                map.put(i, idx++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i: input){
            sb.append(map.get(i)).append(' ');
        }

        System.out.println(sb);
    }
}
