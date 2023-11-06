package dongbinan.tmp;

import java.util.*;
/*
3.미로 탈출

동빈이는 N*M 크기의 직사각형 형태의 미로에 갇혔음.
동빈이 위치는 (1,1) 이며 미로의 출구는 (N,M)에 존재
한칸씩 이동할수 있다.
괴물의 위치는 0, 없으면 1로 표시.
미로는 반드시 탈출할수 있는 형태
이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 갯수 구하기.
시작칸과 마지막칸을 모두 포함해서 계산

101010
111111
000001
111111
111111 -> 답  = 10
        */

public class bfs {
    public static void main(String[] args) {
        String[] base = {"101010", "111111", "000001", "111111", "111111"};
        int h = base.length;
        int w = base[0].length();

        boolean[][] visited = new boolean[h][w];
        int[][] result = new int[h][w];
        Queue<int[]> q = new LinkedList<>();

        bfs(0, 0, q, visited, result, base);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean bfs(int h, int w, Queue<int[]> q, boolean[][] visited, int[][] result, String[] base) {
        q.offer(new int[] {h, w});
        visited[h][w] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            offerThat(pos[0], pos[1]+1, q, visited, result, base, pos);
            offerThat(pos[0], pos[1]-1, q, visited, result, base, pos);
            offerThat(pos[0]+1, pos[1], q, visited, result, base, pos);
            offerThat(pos[0]-1, pos[1], q, visited, result, base, pos);

        }
        return false;
    }

    public static boolean offerThat(int h, int w, Queue<int[]> q, boolean[][] visited, int[][] result, String[] base, int[] OriPos) {
        // 바운더리
        // 장애물
        // 방문 & 처리
        if (h < 0 || w < 0 || h > visited.length-1 || w > visited[0].length-1) {
            return false;
        }
        if (base[h].charAt(w) != '1') {
            return false;
        }
        if (visited[h][w]) {
            return false;
        }
        visited[h][w] = true;

        q.offer(new int[] {h, w});
        result[h][w] = result[OriPos[0]][OriPos[1]] +1;
        return true;
    }
}
