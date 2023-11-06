package programmers.two;

public class Combination_2 {
    public static void main(String[] args) {

        solution();
    }

    public static void solution() {
        int n = 3;
        int r = 2;
        int[] output = new int[r];

        combi(0, 0, n, r, output);
    }

    public static void combi(int cnt, int start, int n, int r, int[] output) {
        if (cnt == r) {
            System.out.println(output[0] + "," + output[1]);
            // result.add(new int[] {output});
            return;
        }

        for (int i = start; i < n; i++) {
            output[cnt] = i;
            combi(cnt+1, i+1, n, r, output);
        }
    }
}
