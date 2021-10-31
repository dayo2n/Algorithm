package BOJ;

import java.util.Scanner;

public class BOJ1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] cal = new int[n + 1];// 인덱스 아니고 숫자

		cal[1] = 0;

		for (int i = 1; i <= n; i++) {
			if (i + 1 <= n)
				if (cal[i + 1] == 0)
					cal[i + 1] = cal[i]+1;
				else
					cal[i + 1] = Math.min(cal[i] + 1, cal[i + 1]);

			if (i * 3 <= n)
				if (cal[i * 3] == 0)
					cal[i * 3] = cal[i] + 1;
				else
					cal[i * 3] = Math.min(cal[i] + 1, cal[i * 3]);

			if (i * 2 <= n)
				if (cal[i * 2] == 0)
					cal[i * 2] = cal[i] + 1;
				else
					cal[i * 2] = Math.min(cal[i] + 1, cal[i * 2]);

		}
		System.out.println(cal[n]);
	}
}
