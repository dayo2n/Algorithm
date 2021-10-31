package BOJ;

import java.util.Scanner;

public class BOJ11726 {

	static int[] tile = new int[1001];

	public static int dp(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (tile[n] != 0)
			return tile[n];
		return tile[n] = (dp(n - 1) + dp(n - 2)) % 10007;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(dp(n));
	}
}
