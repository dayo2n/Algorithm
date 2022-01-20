package BOJ;

import java.util.Scanner;

public class BOJ11050 {
    static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        System.out.println(factorial(N) / (factorial(L) * factorial(N-L)));
    }
}
