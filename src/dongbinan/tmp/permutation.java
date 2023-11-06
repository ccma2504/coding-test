package dongbinan.tmp;

import java.util.*;
public class permutation {
    public static void main(String[] args) {
        // nPr

        int n = 3;
        int r = 2;
        int[] output = new int[r];
        boolean[] visited = new boolean[n];
        ArrayList<int[]> result = new ArrayList<>();

        perm(0, n, r, visited, output, result);
        System.out.println(result);
    }

    public static void perm(int cnt, int n, int r, boolean[] visited, int[] output, ArrayList<int[]> result) {
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
            perm(cnt+1, n, r, visited, output, result);
            visited[i] = false;
        }
    }
}
