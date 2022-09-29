package BOJ;

import java.util.Scanner;

public class BOJ11050_1 {

    // 파스칼의 법칙을 사용한 알고리즘 (재귀)
    static int bino(int n, int k){
        if(k == 0 || n == k) return 1;
        return bino(n-1, k-1) + bino(n-1, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        System.out.println(bino(N, L));
    }
}
