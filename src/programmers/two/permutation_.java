package programmers.two;

import java.util.*;

public class permutation_ {
    public static void main(String[] args) {

        int n = 3;
        int r = 2;
        int[] output = new int[r];
        boolean[] visited = new boolean[n];
        ArrayList<int[]> result = new ArrayList<>();

        perm(0, n, r, output, visited, result);

        System.out.println("--");
        for (int i = 0; i < result.size(); i++) {
            int[] each = result.get(i);
            System.out.println(each[0] + "," + each[1]);
        }
    }

    static void perm(int cnt, int n, int r, int[] output, boolean[] visited, ArrayList<int[]> result) {
        if (cnt == r) {
            result.add(new int[] {output[0], output[1]});
            System.out.println(output[0] + "," + output[1]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            output[cnt] = i;

            perm(cnt + 1, n, r, output, visited, result);
            visited[i] = false;
        }
    }
}
