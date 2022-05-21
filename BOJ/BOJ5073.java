//package BOJ;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BOJ5073 {
//
//    static final String EQ = "Equilateral", IS = "Isosceles", SC = "Scalene", INVALID = "Invalid";
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int a, b, c;
//        while (true) {
//            st = new StringTokenizer(br.readLine());
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//            c = Integer.parseInt(st.nextToken());
//            if (a == 0 && b == 0 && c == 0) break;
//            int max = Math.max(a, Math.max(b, c));
//
//
//            String ans;
//            if (a == b && b == c) ans = EQ;
//            else if ((a == b && b != c) || (a != b && b == c) || (a == c && b != c)) ans = IS;
//            else if (a != b && b != c && a != c) ans = SC;
//
//            if ()
//
//        }
//    }
//}
