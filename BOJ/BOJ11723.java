package BOJ;

import java.util.*;
import java.io.*;
public class BOJ11723 {
    static int bit = 0b0_0000_0000_0000_0000_0000;
    static StringBuilder sb;

    static void add(int x) {
        bit |= (1 << x);
    }
    static void remove(int x) {
        bit &= ~(1 << x);
    }
    static void check (int x){
        if ((bit & (1<<x)) == (1<<x)) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }
    static void toggle(int x){
        bit ^= (1<<x);
    }
    static void all(){
        bit = 0b1_1111_1111_1111_1111_1110;
    }
    static void empty(){
        bit = 0b00;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        String cmd;
        int val = 0;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if (st.hasMoreTokens())
                val = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case "add":
                    add(val);
                    break;
                case "remove":
                    remove(val);
                    break;
                case "check":
                    check(val);
                    break;
                case "toggle":
                    toggle(val);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
