package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ5957 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// Bessie is washing the dishes
		// Canmuu will dry them

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		Stack<Integer> unwashed = new Stack<Integer>();
		Stack<Integer> undried = new Stack<Integer>();
		Stack<Integer> cleaned = new Stack<Integer>();// unwashed&notDried

		for (int i = n; i > 0; i--) {
			unwashed.push(i);
		}

		while (!(cleaned.size() == n)) {
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());// command 값
			int dish = Integer.parseInt(st.nextToken());// 처리할 접시 개수
			if (cmd == 1) {
				for (int i = 0; i < dish; i++) {
					undried.push(unwashed.pop());
				}
			} else if (cmd == 2) {
				for (int i = 0; i < dish; i++) {
					cleaned.push(undried.pop());
				}
			}
		}
		for (int i = 0; i < n; i++)
			System.out.println(cleaned.pop());
	}
}