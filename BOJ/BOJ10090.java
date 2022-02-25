package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 10090,
        tier = BaekjoonTier.PLATINUM_V,
        solveDate = @SolveDate(year = 2022, month = 2 ,day = 26))

public class BOJ10090 {

    static int [] permutation, tmp;
    static int N;
    static long invcnt;

    static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int l = left, m = mid + 1;
        int n = left;

        while (l <= mid || m <= right) {
            if (m > right || (l <= mid && permutation[l] < permutation[m])) tmp[n++] = permutation[l++];
            else {
                invcnt += (mid - l + 1);
                tmp[n++] = permutation[m++];
            }
        }
        System.arraycopy(tmp, left, permutation, left, right - left + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        permutation = new int[N + 1];
        tmp = new int[N + 1];
        invcnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) permutation[n] = Integer.parseInt(st.nextToken());
        mergeSort(1, N);
        System.out.println(invcnt);
    }
}
