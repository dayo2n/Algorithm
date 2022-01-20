package BOJ;
import java.io.*;
import java.util.*;

public class BOJ10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for(int i=0; i<5; i++){
            int check = Integer.parseInt(st.nextToken());
            if(check == day) cnt++;
        }

        System.out.println(cnt);
    }
}
