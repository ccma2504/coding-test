package programmers.two;
import java.util.*;
/*
picks	minerals	result
[1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	12
[0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	50
 */

public class permutation {
    public static void main(String[] args) {

        int n = 3;
        int r = 2;
        int[] output = new int[r];
        boolean[] visited = new boolean[n];

        perm(0, n, r, output, visited);
    }

    static void perm(int cnt, int n, int r, int[] output, boolean[] visited) {

        if (cnt == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[cnt] = i;

            perm(cnt+1, n, r, output, visited);
            visited[i] = false;
        }

    }
}

