package programmers.two;

import java.util.*;
/*
picks	minerals	result
[1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	12
[0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	50
 */

import java.util.ArrayList;

public class permutation_2 {
    public static void main(String[] args) {

        solution();
    }

    public static void solution() {

        int n = 3;
        int r = 2;
        int[] output = new int[r];
        boolean[] visited = new boolean[n];
        ArrayList<int[]> result = new ArrayList<>();

        perm(0, n , r, output, visited, result);
    }

    public static void perm(int cnt, int n, int r, int[] output, boolean[] visited, ArrayList<int[]> result) {
        if (cnt == r) {
            System.out.println(output[0] + "," + output[1]);
            result.add(new int[] {output[0], output[1]});
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[cnt] = i;
            perm(cnt+1, n, r, output, visited, result);
            visited[i] = false;
        }
    }

}
