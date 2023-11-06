package dongbinan.tmp;

public class combination {
    public static void main(String[] args) {
        // nCr
        int n = 3;
        int r = 2;
        int[] output = new int[r];
        boolean[] visited = new boolean[n];

        combi(0, 0, n, r, output, visited);
    }

    public static void combi(int cnt, int start, int n, int r, int[] output, boolean[] visited) {
        if (cnt == r) {
            System.out.println(output[0] + "," + output[1]);
            return;
        }

        for (int i = start; i < n; i++) {
            output[cnt] = i;
            combi(cnt+1, i+1, n, r, output, visited);
        }
    }
}
