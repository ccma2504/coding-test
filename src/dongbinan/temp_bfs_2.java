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
public class temp_bfs_2 {
    public static void main(String[] args) {

        String[] base = {"101010", "111111", "000001", "111111", "111111"};
        solution(base);
    }

    public static void solution(String[] base) {
        int h = base.length;
        int w = base[0].length();

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        int[][] result = new int[h][w];

        dfs(0, 0, q, visited, base, result);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void dfs(int h, int w, Queue<int[]> q, boolean[][] visited, String[] base, int[][] result) {
        int[] pos = {h, w};
        visited[h][w] = true;
        q.offer(pos);

        while (! q.isEmpty()) {
            int[] now = q.poll();

            chkAndOffer(now[0], now[1]+1, q, visited, base, result, now[0], now[1]);
            chkAndOffer(now[0], now[1]-1, q, visited, base, result, now[0], now[1]);
            chkAndOffer(now[0]+1, now[1], q, visited, base, result, now[0], now[1]);
            chkAndOffer(now[0]-1, now[1], q, visited, base, result, now[0], now[1]);
        }

    }

    public static void chkAndOffer(int h, int w, Queue<int[]> q, boolean[][] visited, String[] base, int[][] result, int oriH, int oriW) {
        // 바운더리
        // 방문 & 체크
        // 장애물
        if (h < 0 || w < 0 || h > base.length-1 || w > base[0].length()-1) {
            return;
        }
        if (base[h].charAt(w) == '0' ) {
            return;
        }
        if (visited[h][w]) {
            return;
        }
        visited[h][w] = true;

        q.offer(new int[] {h, w});

        result[h][w] = result[oriH][oriW] + 1;
    }
}
