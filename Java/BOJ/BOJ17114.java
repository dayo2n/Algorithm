package BOJ;

import annotation.*;
import java.io.*;
import java.util.*;

@BOJ(number = 17114,
        tier = BaekjoonTier.GOLD_I,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 14))
public class BOJ17114 {

    static class HyperTomato {
        int[] data;

        HyperTomato(int[] data) {
            this.data = data;
        }
    }

    static int m, n, o, p, q, r, s, t, u, v, w;
    static int[][][][][][][][][][][] days;
    static Queue<HyperTomato> queue;
    static int [] size;
    static int [][] direction = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    static void bfs() {
        while (!queue.isEmpty()) {
            int [] data = queue.poll().data;
            int [] newData;
            boolean flag;
            newData = new int[data.length]; // 없어도 될듯

            for (int idx = 0; idx < direction[0].length; idx ++) {
                flag = true;
                for (int dimension = 0; dimension < 11; dimension++) {
                    newData[dimension] = data[dimension] + direction[dimension][idx];
                    if (newData[dimension] < 0 || newData[dimension] >= size[dimension]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (days[newData[0]][newData[1]][newData[2]][newData[3]][newData[4]][newData[5]][newData[6]][newData[7]][newData[8]][newData[9]][newData[10]] == 0) {
                        days[newData[0]][newData[1]][newData[2]][newData[3]][newData[4]][newData[5]][newData[6]][newData[7]][newData[8]][newData[9]][newData[10]]
                                = days[data[0]][data[1]][data[2]][data[3]][data[4]][data[5]][data[6]][data[7]][data[8]][data[9]][data[10]] + 1;
                        queue.offer(new HyperTomato(new int[]{newData[0], newData[1], newData[2], newData[3], newData[4], newData[5], newData[6], newData[7], newData[8], newData[9], newData[10]}));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        o = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        size = new int[]{m, n, o, p, q, r, s, t, u, v, w};
        queue = new LinkedList<>();

        days = new int[m][n][o][p][q][r][s][t][u][v][w];

        boolean isAllRipen = true;
        for (int W = 0; W < w; W++) {
            for (int V = 0; V < v; V++) {
                for (int U = 0; U < u; U++) {
                    for (int T = 0; T < t; T++) {
                        for (int S = 0; S < s; S++) {
                            for (int R = 0; R < r; R++) {
                                for (int Q = 0; Q < q; Q++) {
                                    for (int P = 0; P < p; P++) {
                                        for (int O = 0; O < o; O++) {
                                            for (int N = 0; N < n; N++) {
                                                st = new StringTokenizer(br.readLine());
                                                for (int M = 0; M < m; M++) {
                                                    int tomato = Integer.parseInt(st.nextToken());
                                                    if (tomato == 1) {
                                                        queue.add(new HyperTomato(new int[] {M, N, O, P, Q, R, S, T, U, V, W}));
                                                        days[M][N][O][P][Q][R][S][T][U][V][W] = 1;
                                                    } else if (tomato == -1)
                                                        days[M][N][O][P][Q][R][S][T][U][V][W] = -1;
                                                    else isAllRipen = false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isAllRipen) {
            System.out.println(0);
            return;
        }
        bfs();
        int maxDay = 0;

        for (int W = 0; W < w; W++) {
            for (int V = 0; V < v; V++) {
                for (int U = 0; U < u; U++) {
                    for (int T = 0; T < t; T++) {
                        for (int S = 0; S < s; S++) {
                            for (int R = 0; R < r; R++) {
                                for (int Q = 0; Q < q; Q++) {
                                    for (int P = 0; P < p; P++) {
                                        for (int O = 0; O < o; O++) {
                                            for (int N = 0; N < n; N++) {
                                                for (int M = 0; M < m; M++) {
                                                    int curDay = days[M][N][O][P][Q][R][S][T][U][V][W];
                                                    if (curDay == 0) { // 하나라도 0이 있으면 모두 익지못하는 상황
                                                        System.out.println(-1);
                                                        return;
                                                    }
                                                    if (curDay > maxDay) maxDay = curDay;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxDay - 1);
    }
}
