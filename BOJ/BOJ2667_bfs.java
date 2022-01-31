package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Apartment {
    int x, y;
    Apartment(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ2667_bfs {
    static int[][] graph;
    static int N; // 정사각형 길이
    static Queue<Apartment> q = new LinkedList<>();
    static ArrayList<Integer> res = new ArrayList<>();

    static void bfs(int row, int col, int building) {
        q.add(new Apartment(row, col));
        graph[row][col] = building;

        int cnt = 1;

        while (!q.isEmpty()) {
            Apartment cur = q.poll();

            int [] updown = {-1, 1, 0, 0};
            int [] leftright = {0, 0, -1, 1};
            for (int i=0; i<4; i++) {
                int newX = cur.x + updown[i];
                int newY = cur.y + leftright[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                    if (graph[newX][newY] == 1) {
                        graph[newX][newY] = building;
                        cnt++;
                        q.add(new Apartment(newX, newY));
                    }
                }
            }
        }
        res.add(cnt);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<N; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        int building = 1; // 단지번호
        // 집이 있는 것을 1로 표현하기 때문에 단지와 집 존재의 구분을 위해 단지번호는 2부터 시작해야함을 유의
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (graph[i][j] == 1 ) {
                    bfs(i, j, ++building);
                }
            }
        }

        System.out.println(building-1);
        res.sort(null);
        for (int val : res) {
            System.out.println(val);
        }
    }
}
