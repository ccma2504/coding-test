package boj.bfs._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int length = Integer.parseInt(br.readLine());

            for (int i = 0; i < length; i++) {
                String first = br.readLine();
                String[] firsts = first.split(" ");
                int w = Integer.parseInt(firsts[0]);
                int h = Integer.parseInt(firsts[1]);
                int size = Integer.parseInt(firsts[2]);// rename

                int[][] table = new int[h][w];
                for (int j = 0; j < size; j++) {
                    String info = br.readLine();
                    String[] infos = info.split(" ");

                    int _h = Integer.parseInt(infos[0]);
                    int _w = Integer.parseInt(infos[1]);

                    table[_w][_h] = 1;
                }

                solution(table, h, w);
            }

            br.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void solution(int[][] table, int h, int w) {
        // for (int i = 0; i < h; i++) {
        //     for (int j = 0; j < w; j++) {
        //         System.out.print(table[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // 검산
        /* 한번 갈때, 1인경우 true 처리, 단 방문했으면 pass
         * DFS, 이중 for loop,
            dfs 호출
                장애물 처리
                바운더리 처리
                방문여부 처리

                4방향 재귀 호출
         *
         */
        int rtn = 0;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if( dfs(i, j, table, visited) ) {
                    rtn++;
                }
            }
        }
        System.out.println(rtn);

    }

    public static boolean dfs(int i, int j, int[][] table, boolean[][] visited) {
        if (i < 0 || j < 0 || i > table.length-1 || j > table[0].length-1) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (table[i][j] != 1) {
            return false;
        }

        dfs(i, j+1, table, visited);
        dfs(i, j-1, table, visited);
        dfs(i+1, j, table, visited);
        dfs(i-1, j, table, visited);

        return true;
    }
}
