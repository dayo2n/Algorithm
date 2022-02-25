package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1392 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int music[] = new int[N];
        int time[] = new int[Q];
        for(int i=0; i<N; i++) {
            music[i] = Integer.parseInt(br.readLine());
        }

        for(int j=0; j<Q; j++) {
            time[j] = Integer.parseInt(br.readLine());
        }
        int idx=1;
        int I = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(true) {
            list.add(idx);
            music[I]--;
            if(music[I]==0) {
                I++;
                idx++;
            }
            if(I==N)
                break;
        }

        for(int i=0; i<time.length; i++) {
            sb.append(list.get(time[i])).append("\n");
        }
        System.out.println(sb);
    }
}