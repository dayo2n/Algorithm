package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] score = new int[8];
		int[] index = new int[8];

		for (int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();
			index[i] = score[i];
		}

		Arrays.sort(score);
		int sum = 0;
		String ans = "";
		int[] newIndex = new int[5];

		for (int i = 3; i < 8; i++) {
			sum += score[i];
			for (int j = 0; j < index.length; j++) {
				if (score[i] == index[j]) {
					newIndex[i - 3] = j+1;
					break;
				}
			}
		}

		Arrays.sort(newIndex);

		System.out.println(sum);
		for (int i = 0; i < 5; i++) {
			System.out.print(newIndex[i] + " ");
		}
	}
}