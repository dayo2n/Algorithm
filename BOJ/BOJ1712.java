package BOJ;

import java.util.Scanner;

public class BOJ1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 고정지출
        int B = sc.nextInt(); // 노트북 한 대 생산에 드는 가변비용
        int C = sc.nextInt(); // 책정된 노트북 가격

        if (B >= C) {
            System.out.println(-1);
            return;
        }
        System.out.println(A / (C-B) + 1);
    }
}
