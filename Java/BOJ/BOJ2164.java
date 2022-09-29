package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> card = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            card.add(i);
        }

        while (true) {
            if (card.size() == 1) {
                System.out.println(card.poll());
                break;
            }
            card.poll();
            card.add(card.poll());
        }
    }
}