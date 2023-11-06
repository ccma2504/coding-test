package dongbinan;

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
public class temp_bfs {
    public static void main(String[] args) {
        String[] base = {"101010", "111111", "000001", "111111", "111111"};
        int h = base.length;
        int w = base[0].length();

        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        int[][] result = new int[h][w];

        bfs(0, 0, visited, base, result, q);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void bfs(int h, int w, boolean[][] visited, String[] base, int[][] result, Queue<Integer[]> q) {
        Integer[] pos_ = {h, w};
        q.offer(pos_);
        visited[h][w] = true;

        while (! q.isEmpty()) {
            Integer[] pos = q.poll();

            checkNOffer(pos[0], pos[1]-1, visited, base, result, q, result[pos[0]][pos[1]]);
            checkNOffer(pos[0], pos[1]+1, visited, base, result, q, result[pos[0]][pos[1]]);
            checkNOffer(pos[0]-1, pos[1], visited, base, result, q, result[pos[0]][pos[1]]);
            checkNOffer(pos[0]+1, pos[1], visited, base, result, q, result[pos[0]][pos[1]]);
        }
    }

    public static void checkNOffer(int h, int w, boolean[][] visited, String[] base, int[][] result, Queue q, int ori) {
        // 바운더리
        // 장에물
        // 방문여부

        if (h < 0 || w < 0 || h > visited.length-1 || w > visited[0].length-1) {
            return;
        }
        String row = base[h];
        char c = row.charAt(w);
        if ('1' != c) {
            return;
        }
        if (visited[h][w]) {
            return;
        }
        visited[h][w] = true;

        q.offer(new Integer[]{h, w});

        result[h][w] = ori+1;

    }
}
