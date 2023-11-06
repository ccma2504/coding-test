package programmers.two;

import java.util.*;

public class permutation2 {
    public static void main(String[] args) {

        int n = 3;
        int r = 2;
        int[] result = new int[r];
        boolean[] visited = new boolean[n];

        perm(0, n, r,result, visited);
    }
    // 변수명에 문제가 있네

    static void perm(int cnt, int n, int r, int[] result, boolean[] visited) {
        if (cnt == r) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[cnt] = i;

            perm(cnt + 1, n, r, result, visited);
            visited[i] = false;
        }
    }
}
