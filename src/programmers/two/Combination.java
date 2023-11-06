package programmers.two;
import java.util.*;
public class Combination {

    public static void main(String[] args) {

        solution();
    }

    static void solution() {
        int n = 3;
        int r = 2;
        int[] output = new int[r];

        combiate(0, 0, n, r, output);
    }

    static void combiate(int cnt, int start, int n, int r, int[] output) {
        if (cnt == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = start; i < n; i++) {
            output[cnt] = i;
            combiate(cnt+1, i+1, n, r, output);
        }
    }
}
